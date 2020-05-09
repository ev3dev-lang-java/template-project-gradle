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

To start, change the `host`, `user` and `password` properties in `config.gradle`. Then, continue to the brick setup.

## Configuration

You can change the project configuration in `config.gradle`.

## Javadocs

The project has the following technical documentation

http://ev3dev-lang-java.github.io/docs/api/latest/index.html

## Examples

Exist several examples ready to use here:

https://github.com/ev3dev-lang-java/examples

## Issues

If you have any problem or doubt, use the main projet.

https://github.com/ev3dev-lang-java/ev3dev-lang-java/issues
