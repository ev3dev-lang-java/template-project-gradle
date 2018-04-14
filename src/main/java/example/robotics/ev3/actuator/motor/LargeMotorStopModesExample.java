package example.robotics.ev3.actuator.motor;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LargeMotorStopModesExample {

    public static Logger LOGGER = LoggerFactory.getLogger(LargeMotorStopModesExample.class);

    public static final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);

    public static void main(String[] args) {

        LOGGER.info("Starting motors on A");
        mA.setSpeed(500);

        LOGGER.info("Testing brake stop mode");
        mA.brake();
        mA.forward();
        LOGGER.info("Large Motor is moving: {} at speed {}", mA.isMoving(), mA.getSpeed());
        Delay.msDelay(2000);
        mA.stop();

        Delay.msDelay(2000);

        LOGGER.info("Testing hold stop mode");
        mA.hold();
        mA.forward();
        LOGGER.info("Large Motor is moving: {} at speed {}", mA.isMoving(), mA.getSpeed());
        Delay.msDelay(2000);
        mA.stop();

        Delay.msDelay(2000);

        LOGGER.info("Testing coast stop mode");
        mA.coast();
        mA.forward();
        LOGGER.info("Large Motor is moving: {} at speed {}", mA.isMoving(), mA.getSpeed());
        Delay.msDelay(2000);
        mA.stop();

        LOGGER.info("Stopped motors");
    }

}
