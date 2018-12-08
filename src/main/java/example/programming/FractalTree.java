package example.programming;

import ev3dev.actuators.LCD;
import ev3dev.utils.JarResource;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.robotics.Color;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FractalTree {

    public static Logger LOGGER = LoggerFactory.getLogger(FractalCircle.class);

    private GraphicsLCD g;

    public FractalTree() {
        g = LCD.getInstance();

        showJavaLogo(g);
        Delay.msDelay(5000);
        clear(g);
    }
 
    public void drawTree(int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
        g.refresh();
        drawTree(x2, y2, angle - 20, depth - 1);
        drawTree(x2, y2, angle + 20, depth - 1);
    }

    public static void clear(GraphicsLCD g) {
        //lcd.setColor(Color.WHITE);
        g.setColor(255,255,255);
        g.fillRect(0,0, g.getWidth(), g.getHeight());
    }

    public static final String JAVA_DUKE_IMAGE_NAME = "java_logo.png";

    private static void showJavaLogo(GraphicsLCD lcd) {

        try {
            BufferedImage image  = JarResource.loadImage(JAVA_DUKE_IMAGE_NAME);
            lcd.drawImage(image, 35, 10, 0);
            lcd.refresh();
        }catch (IOException e){
            LOGGER.error(e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {

        FractalTree fractal = new FractalTree();
        fractal.drawTree( 178/2, 128, -90, 5);

        Delay.msDelay(10000);
    }
}
