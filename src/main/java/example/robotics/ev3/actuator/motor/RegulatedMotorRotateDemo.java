package example.robotics.ev3.actuator.motor;

import ev3dev.actuators.Sound;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegulatedMotorRotateDemo {

    public static Logger LOGGER = LoggerFactory.getLogger(MotorEncoderExample2.class);

    public static final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
    public static final int DEGREES_TO_ROTATE = 90;

    public static final Sound sound = Sound.getInstance();

    public static void main(String[] args) {

        mA.resetTachoCount();
        mA.setSpeed(100);
        mA.hold();

        sound.beep();
        Delay.msDelay(1000);
        LOGGER.info("Tacho Count: {}", mA.getTachoCount());
        mA.rotate(DEGREES_TO_ROTATE);

        sound.beep();
        Delay.msDelay(1000);
        LOGGER.info("Tacho Count: {}", mA.getTachoCount());
        mA.rotate(DEGREES_TO_ROTATE);

        sound.beep();
        Delay.msDelay(1000);
        LOGGER.info("Tacho Count: {}", mA.getTachoCount());
        mA.rotate(DEGREES_TO_ROTATE);

        sound.beep();
        Delay.msDelay(1000);
        LOGGER.info("Tacho Count: {}", mA.getTachoCount());

    }

}
