package example.robotics.ev3.actuator;

import ev3dev.actuators.LCD;
import ev3dev.hardware.EV3DevDistro;
import ev3dev.hardware.EV3DevDistros;
import ev3dev.utils.Brickman;
import ev3dev.utils.JarResource;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class LCDShowJavaLogoExample {

    public static Logger LOGGER = LoggerFactory.getLogger(LCDShowJavaLogoExample.class);

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(final String[] args) {

        if(EV3DevDistros.getInstance().getDistro().equals(EV3DevDistro.JESSIE)) {
            Brickman.disable();
        }

        LOGGER.info("EV3 LCD Example");

        showJavaLogo();
        Delay.msDelay(5000);

    }

    public static final String JAVA_DUKE_IMAGE_NAME = "java_logo.png";

    private static void showJavaLogo() {

        if(LOGGER.isDebugEnabled())
            LOGGER.debug("Showing Java logo on EV3 Brick");

        try {
            BufferedImage image  = JarResource.loadImage(JAVA_DUKE_IMAGE_NAME);
            lcd.drawImage(image, 35, 10, 0);
            lcd.refresh();
        }catch (IOException e){
            LOGGER.error(e.getLocalizedMessage());
        }
    }

}
