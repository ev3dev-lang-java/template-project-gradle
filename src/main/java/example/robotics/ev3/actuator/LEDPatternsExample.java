package example.robotics.ev3.actuator;

import ev3dev.actuators.ev3.EV3Led;
import lejos.hardware.LED;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LEDPatternsExample {

    public static Logger LOGGER = LoggerFactory.getLogger(LEDPatternsExample.class);

    public static void main(String[] args) {

        LOGGER.info("Example with EV3 Led patterns");

        leftPatterns();
        rightPatterns();

    }

    public static void leftPatterns(){

        LOGGER.info("Left patterns");

        LED led = new EV3Led(EV3Led.LEFT);
        led.setPattern(0);
        Delay.msDelay(1000);
        led.setPattern(1);
        Delay.msDelay(1000);
        led.setPattern(2);
        Delay.msDelay(1000);
        led.setPattern(3);
        Delay.msDelay(1000);
        led.setPattern(0);
        Delay.msDelay(1000);
    }

    public static void rightPatterns(){

        LOGGER.info("Right patterns");

        LED led = new EV3Led(EV3Led.RIGHT);

        led.setPattern(0);
        Delay.msDelay(1000);
        led.setPattern(1);
        Delay.msDelay(1000);
        led.setPattern(2);
        Delay.msDelay(1000);
        led.setPattern(3);
        Delay.msDelay(1000);
        led.setPattern(0);
        Delay.msDelay(1000);

    }

}