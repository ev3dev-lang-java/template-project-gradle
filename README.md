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

Review the IP of your Brick and update the file `./config.gradle`:

```
remotes {
    ev3dev {
        host = '192.168.1.180'
        user = 'robot'
        password = 'maker'
    }
}
```

### EV3Dev-lang-java

The tasks associated to deploy on your Robot are:

- testConnection (Test the connection with your Brick)
- deploy (The project deliver a FatJar to your Brick)
- remoteRun (Execute a Jar deployed on your Brick)
- deployAndRun (Deploy & Execute from your Computer the program that you configured on the file: MANIFEST.MF)
- ev3devInfo (Get technical information about your EV3 Brick)
- removePreviousJar (Remove current jar remotely)
- remoteBrickRun (If your program is going to use some EV3 Actuator like LCD, Buttons, use this task to execute the program)
- remoteRun (Execute your jar remotely)
- remoteRunClassVerbose (Execute your jar and show JVM info)
- remoteProfilingRun (Execute your jar configured for Profiling activities)
- deployAndBrickRun (Deploy & Execute your program with Brickrun)
- deployAndProfilingRun  (Deploy & Execute your jar configured for Profiling activities)
- pkillJava (Kill Java processes in your Brick)

You can use the Java IDE to launch the task or execute them from the terminal

```
./gradlew deployAndBrickRun
```

## Javadocs

The project has the following technical documentation

http://ev3dev-lang-java.github.io/docs/api/latest/index.html

## Examples

Exist several examples ready to use here:

https://github.com/ev3dev-lang-java/examples

## Issues

If you have any problem or doubt, use the main project.

https://github.com/ev3dev-lang-java/ev3dev-lang-java/issues
