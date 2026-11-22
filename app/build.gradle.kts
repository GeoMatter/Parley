plugins {
    id("com.android.application")
}

// CI passes the GitHub run number, so every build gets a higher version automatically.
val ciVersionCode = System.getenv("VERSION_CODE")?.toIntOrNull() ?: 1
// Release builds take the name from the git tag (v1.2 -> 1.2); other builds are "dev".
val ciVersionName = System.getenv("VERSION_NAME")?.removePrefix("v")?.takeIf { it.isNotBlank() } ?: "dev"
val keystoreFile: String? = System.getenv("KEYSTORE_FILE")

android {
    namespace = "com.geomatter.parley"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.geomatter.parley"
        minSdk = 29
        targetSdk = 34
        versionCode = ciVersionCode
        versionName = ciVersionName
    }

    buildFeatures {
        buildConfig = true
    }

    signingConfigs {
        create("release") {
            if (keystoreFile != null) {
                storeFile = file(keystoreFile)
                storePassword = System.getenv("KEYSTORE_PASSWORD")
                keyAlias = System.getenv("KEY_ALIAS")
                keyPassword = System.getenv("KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // Permanent key when the secrets are present; throwaway debug key otherwise.
            signingConfig = if (keystoreFile != null) {
                signingConfigs.getByName("release")
            } else {
                signingConfigs.getByName("debug")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
