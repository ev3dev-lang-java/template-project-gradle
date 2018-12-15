# Template project with Gradle

## Why

Test a new technology is always a bit tedious and it requires an amount of time.
So, this project try to reduce the curve of learning of any new user with `EV3Dev-lang-java`.

## Prerequisites

The Prerequisites to use this project are:

- Your MINDSTORMS Brick needs to have installed latest `Debian Stretch` version. https://www.ev3dev.org/docs/getting-started/
- To increase the EV3 CPU Speed, read the following article: https://lechnology.com/2018/06/overclocking-lego-mindstorms-ev3-part-2/
- Your MINDSTORMS Brick needs to be connected to the same LAN than your laptop. http://www.ev3dev.org/docs/getting-started/#step-5-set-up-a-network-connection

Note: Update the EV3Dev kernel
https://www.ev3dev.org/docs/tutorials/upgrading-ev3dev/

```
sudo apt-get update
sudo apt-get install linux-image-ev3dev-ev3
```

Once you have all steps done, continue with the next section.

## Getting Started

This repository stores a template project about `EV3Dev-lang-java`.
Once you download in your computer the project,
open your favourite Java IDE ( [Eclipse](https://eclipse.org/home/index.php) or [IntelliJ](https://www.jetbrains.com/idea/))
to import this [Gradle](https://gradle.org/) project. The project includes latest dependencies and
an example ready to be deployed on your Robot using the `core` library from `EV3Dev-lang-java`.

The project includes some tasks to reduce the time to deploy on your robot.

To start, change the `brickHost`, `brickUser` and `brickPassword` properties in `config.gradle`. Then, continue to the brick setup.

## Brick setup
### EV3
OpenJDK JRI is preinstalled in the default image, so you only need to install ev3dev-lang-java libraries:
```bash
./gradlew getInstaller installJavaLibraries
```
If you want to use RXTX or OpenCV, you can install them this way:
```bash
./gradlew updateAPT installOpenCV installRXTX
```

### Other platforms
On these platforms OpenJDK JRE needs to be installed from Debian repositories too:
```bash
./gradlew getInstaller updateAPT installJava installJavaLibraries
```
If you want to use RXTX or OpenCV, you can again install them this way:
```bash
./gradlew updateAPT installOpenCV installRXTX
```

## Configuration

You can change the project configuration in `config.gradle`.
- `mainClass` - Main class of your program.
- `brickHost` - IP address of your brick.
- `brickUser` - Username on your brick.
- `brickPassword` - Password for the `brickUser`.
- `opencv` - Whether to include OpenCV libraries.
- `rxtx` - Whether to include RXTX library.
- `userClasspath` - List of additional URLs for runtime Java classpath.
- `useTime` - Can be used to measure the time for which the program runs.
- `useBrickman` - Should be used when running the program on a brick with a display.
- `useSudo` - If true, the program is launched under root.
- `jvmFlags` - Flags for Java Virtual Machine.
  - `-Xlog:class+load=info,class+unload=info ` - Display the debugging info for class loading.
  - `-Xshare:on ` - Enable Class Data Sharing (recommended).
  - `-Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=7091 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false ` - Enable JMX agent.
  - `-noverify ` - Do not verify class bytecode. This can be used to speed up startup time, but it is also a potential big security risk.
  - `-XX:TieredStopAtLevel=1 ` - Do not perform many optimizations. This can be used to speed up startup time.
  - `-Djava.security.egd=file:/dev/./urandom ` - This can be used to speed up random number generation.
- `slimJar` - Whether to generate a small JAR with external dependencies, or rather to generate a fat jar with embedded dependencies.
- `useEmbeddedPaths` - Whehter to use classpath and mainclass embedded in JAR or if they should be supplied on the command line.

## Gradle Tasks

The project has some tasks developed to interact in 3 areas:

- EV3Dev-lang-java
- EV3Dev
- Installer


You can use the Java IDE to launch the tasks or you can execute them from the terminal:
```bash
./gradlew deployRun
```

### EV3Dev-lang-java tasks
- `testConnection` - Test connection to the brick.
- `deploy` - Deploy a new build of the program to the brick.
- `deployRun` - Deploy a new build of the program to the brick and then run it.
- `run` - Run the program that is currently loaded on the brick.
- `undeploy` - Remove previously uploaded JAR.
- `pkillJava` - Kill running Java instances.
- `fatJar` - Build a fat JAR with all dependencies included inside.

### Installer tasks
- `helpInstall` - Print the installer help.
- `getInstaller` - Download the installer to the brick.
- `installJava` - Install Java on the brick.
- `installOpenCV` - Install OpenCV libraries on the brick.
- `installRXTX` - Install RXTX library on the brick.
- `installJavaLibraries` - Install EV3Dev-lang-java libraries on the brick.
- `javaVersion` - Print Java version which is present on the brick.
- `updateAPT` - Update APT package cache.

### EV3Dev tasks
- `ev3devInfo` - Get system summary from `ev3dev-sysinfo -m`.
- `free` - Print free memory summary.
- `getDebianDistro` - Get Debian version information from `/etc/os-release`.
- `ps` - Print list of running processes.
- `stopBluetooth`/`restartBluetooth` - Stop/restart the Bluetooth service.
- `stopBrickman`/`restartBrickman` - Stop/restart the Brickman service.
- `stopNmbd`/`restartNmbd` - Stop/restart the NMBD service.
- `stopNtp`/`restartNtp` - Stop/restart the NTP service.
- `shutdown` - Shut down the brick.

## Javadocs

The project has the following technical documentation

http://ev3dev-lang-java.github.io/docs/api/latest/index.html

## Examples

Exist several examples ready to use here:

https://github.com/ev3dev-lang-java/examples

## Issues

If you have any problem or doubt, use the main projet.

https://github.com/ev3dev-lang-java/ev3dev-lang-java/issues
