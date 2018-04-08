package example.robotics.ev3.actuator;

import ev3dev.sensors.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example show how to use the EV3 Buttons
 */
public class ButtonExample {

    public static Logger LOGGER = LoggerFactory.getLogger(ButtonExample.class);

    public static void main(final String[] args) {

        LOGGER.info("Play with EV3 Buttons");

        LOGGER.info("Press UP");
        Button.UP.waitForPress();
        LOGGER.info("Pressed UP");

        LOGGER.info("Press DOWN");
        Button.DOWN.waitForPress();
        LOGGER.info("Pressed DOWN");

        LOGGER.info("Press LEFT");
        Button.LEFT.waitForPress();
        LOGGER.info("Pressed LEFT");

        LOGGER.info("Press RIGHT");
        Button.RIGHT.waitForPress();
        LOGGER.info("Pressed RIGHT");

        LOGGER.info("Press ESCAPE");
        Button.ESCAPE.waitForPress();
        LOGGER.info("Pressed ESCAPE");

        LOGGER.info("Press ENTER");
        Button.ENTER.waitForPress();
        LOGGER.info("Pressed ENTER");

    }
}