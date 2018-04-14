package example.robotics.ev3.actuator.motor;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example explain how to use a EV3 Large Motor
 */
public class EV3LargeMotorExample {

    public static Logger LOGGER = LoggerFactory.getLogger(EV3LargeMotorExample.class);

    public static final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);

    public static void main(String[] args) {

        LOGGER.info("Example using a EV3 Large Motor");
        mA.setSpeed(500);
        mA.brake();
        mA.forward();

        LOGGER.info("Large Motor is moving: {} at speed {}", mA.isMoving(), mA.getSpeed());

        Delay.msDelay(2000);
        mA.stop();
    }

}
