# Parley: Claude for Quest (unofficial)

A lightweight app that runs Claude on Meta Quest. It opens the Claude web app (claude.ai) full-window as its own app in your library, so you can chat with Claude without juggling browser tabs.

> **Unofficial.** Not affiliated with, endorsed by, or sponsored by Anthropic. "Claude" is a trademark of Anthropic. Parley simply loads `claude.ai`.

## Privacy
Parley doesn't collect, store, or send any data of its own. You sign in directly with Claude, and everything goes straight between your headset and Anthropic's servers. The only other request Parley makes is a check of this repo's latest release number, to tell you when an update is out.

## Features
- Opens straight into a new chat
- Stays signed in between launches
- Microphone support for voice input (asked for the first time you use it)
- File and image uploads through the system picker
- Tells you when a new version is available
- Other links and downloads open in the Quest browser
- Resizable panel (defaults to 1280×800)

## Install
1. Download `Parley.apk` from the [latest release](https://github.com/GeoMatter/Parley/releases/latest), or get it on SideQuest.
2. Connect your Quest with USB debugging on and drag the APK into SideQuest.
3. In the headset, go to **Library → Unknown Sources → Parley**.

## Signing in
Use **your email address**. "Continue with Google" doesn't work inside Parley, because Google blocks sign-ins in embedded browsers.

## Requires
A Claude account (free or paid).

## Known limits
- No notifications while the app is closed.
- Voice input depends on what the Claude website supports in this browser and may not work everywhere.

## Problems or ideas?
Report them at https://github.com/GeoMatter/Parley/issues

## Releasing (maintainer notes)
Every push to `main` builds a test APK under **Actions**. To publish a release:
```
git tag v1.1
git push origin v1.1
```
GitHub builds a signed `Parley.apk`, attaches it to a new release, and installed copies of Parley will offer the update. Releases need the four signing secrets (`KEYSTORE_BASE64`, `KEYSTORE_PASSWORD`, `KEY_ALIAS`, `KEY_PASSWORD`) set in the repo's **Settings → Secrets and variables → Actions**.

## License
MIT
