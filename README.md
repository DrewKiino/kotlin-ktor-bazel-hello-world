
# Kotlin-Ktor-Bazel API Server

## Installation

1. Download [bazel](https://bazel.build/) (our build system)

2. Download [intellij](https://www.jetbrains.com/idea/download/other.html) (ide)

  Note: as of 06/20 the bazel intellij plugin doesn't work for Windows and does not work on 2020 versions of IntelliJ. 
  Please view the plugin's page for most recent releases and the supported IntelliJ versions. 

3. Download [bazel intellij plugin](https://plugins.jetbrains.com/plugin/8609-bazel/versions) (build plugin for intellij)

  Note: 
  * the plugin can be installed via IntelliJ instead of downloading the jar at the link
  * as of 6/20, the plugin does not support Windows per [this page](https://ij.bazel.build/docs/bazel-support.html)
  * Make sure your JAVA version in your computer is 11 or higher. You can know by doing `java --version` in the terminal
  * Make sure you set your Kotlin JVM to 11 in IntelliJ and Kotlin version to Stable
  * Import your project as a Bazel project and use Bazel Sync get imports working

## Importing This project into IntelliJ

Prereqs: Installation step above

1. Import Bazel Project

2. Select root API folder

3. On Select project view (.bazelproject) page, select 'create from scratch'

4. Under `Project View` -> `Additional Languages`, uncomment `kotlin`, and finish

! If Bazel does not sync, you can copy the path from executing `which bazel` in the terminal in IntelliJ or on your machines terminal, then go to Preferences/Settings -> Bazel Settings -> and paste the returned path from `which bazel` into the Bazel binary location and save


## Commands

To locally run a service by starting its API server
```shell script
bazel run //service/app/public/api:app-api-deployable
```

To simply build the service
```shell script
bazel build //service/app/public/api:app-api
```
