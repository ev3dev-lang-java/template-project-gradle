package example.robotics.ev3.actuator.motor;

import ev3dev.actuators.Sound;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegulatedMotorRotateToDemo {

    public static Logger LOGGER = LoggerFactory.getLogger(MotorEncoderExample2.class);

    public static final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
    public static final int DEGREES_TO_ROTATE = 90;

    public static final Sound sound = Sound.getInstance();

    public static void main(String[] args) {

        int currentDegrees =  0;

        mA.resetTachoCount();
        mA.setSpeed(100);
        mA.hold();

        LOGGER.info("Tacho Count: {}", mA.getTachoCount());
        currentDegrees += DEGREES_TO_ROTATE;
        LOGGER.info("Degrees to rotate: {}" + currentDegrees);
        mA.rotateTo(currentDegrees);
        sound.beep();
        Delay.msDelay(1000);

        LOGGER.info("Tacho Count: {}", mA.getTachoCount());
        currentDegrees += DEGREES_TO_ROTATE;
        LOGGER.info("Degrees to rotate: {}" + currentDegrees);
        mA.rotateTo(currentDegrees);
        sound.beep();
        Delay.msDelay(1000);

        LOGGER.info("Tacho Count: {}", mA.getTachoCount());
    }
}
