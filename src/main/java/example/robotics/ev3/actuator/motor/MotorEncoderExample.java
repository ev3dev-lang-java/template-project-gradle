package example.robotics.ev3.actuator.motor;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example show how to use the motor enconder capabilities
 * included with any EV3 Large Motor.
 */
public class MotorEncoderExample {

    public static Logger LOGGER = LoggerFactory.getLogger(MotorEncoderExample.class);

    public static RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);

    public static void main(String[] args){

        motor.resetTachoCount();
        motor.coast();

        for (int x=1; x < 20; x++){

            LOGGER.info("Tacho Count: {}", motor.getTachoCount());
            Delay.msDelay(500);
        }

    }

}
