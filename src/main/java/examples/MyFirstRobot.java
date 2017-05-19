package examples;

import ev3dev.actuators.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

public @Slf4j class MyFirstRobot {

    public static void main(final String[] args){

        log.info("Starting motor on A");
        final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        log.info("Starting motor on B");
        final EV3LargeRegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);
        mB.brake();

        mA.setSpeed(500);
        mA.forward();
        log.info("Large Motor is moving: {} at speed {}", mA.isMoving(), mA.getSpeed());

        mB.setSpeed(500);
        mB.forward();
        log.info("Medium Motor is moving: {} at speed {}", mB.isMoving(), mB.getSpeed());

        Delay.msDelay(2000);
        mA.stop();
        mB.stop();
        log.info("Stopped motors");
    }
}
