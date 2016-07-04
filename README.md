# atmosphere-commons
The common libraries of the ATMOSPHERE mobile testing framework.

## Project setup

### Export the Android SDK library
The atmosphere-commons depends on a library which is part of the Android SDK. The Android SDK license does not allow us to distribute Android SDK libraries separately, so we need to extract the libraries from your local Android SDK installation. You can find instructions on how to do this [here](https://github.com/MusalaSoft/atmosphere-docs/blob/master/setup/maven_android_sdk_deployer.md).

### Build the project
You can build the project using the included Gradle wrapper by running:
* `./gradlew build` on Linux/macOS
* `gradlew build` on Windows.

### Publish to Maven Local
If the build is successful, also run:
* `./gradlew publishToMavenLocal` (Linux/macOS)
* `gradlew publishToMavenLocal` (Windows)

to publish the jar to the local Maven repository, so other projects that depend on it can use it.
