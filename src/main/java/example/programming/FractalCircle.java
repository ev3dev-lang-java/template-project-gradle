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

public class FractalCircle {

    public static Logger LOGGER = LoggerFactory.getLogger(FractalCircle.class);

    private GraphicsLCD lcd;

    public FractalCircle() {

        lcd = LCD.getInstance();

        showJavaLogo(lcd);

        Delay.msDelay(4000);

        clear(lcd);
        fourFractalCircle(
                1,
                25,
                0,
                128,
                lcd);

        Delay.msDelay(5000);

        clear(lcd);
        fourFractalCircle(
                2,
                25,
                0,
                128,
                lcd);

        Delay.msDelay(5000);

        clear(lcd);
        fourFractalCircle(
                3,
                25,
                0,
                128,
                lcd);

        Delay.msDelay(5000);

        clear(lcd);
        fourFractalCircle(
                4,
                25,
                0,
                128,
                lcd);

        Delay.msDelay(5000);
    }
    

    public static void main(String[] args) {
        FractalCircle main = new FractalCircle();
    }

    public static void fourFractalCircle(int interacoes, int x, int y, int tamanho, GraphicsLCD g) {
        if (interacoes == 0) {

        } else {
            g.setColor(Color.BLACK);
            g.drawOval(x, y, tamanho, tamanho);
            g.refresh();
            fourFractalCircle(interacoes - 1, x+tamanho / 4, y, tamanho / 2, g); //chamada recurssiva para desenhar circulos na parte superior
            fourFractalCircle(interacoes - 1, x, y+tamanho / 4, tamanho / 2, g);//chamada recurssiva para desenhar circulos na parte esquerda
            fourFractalCircle(interacoes - 1, x + tamanho / 2, y+tamanho / 4, tamanho / 2, g);////chamada recurssiva para desenhar circulos na parte direita
            fourFractalCircle(interacoes - 1, x+ tamanho / 4, y + tamanho / 2, tamanho / 2, g);//chamada recurssiva para desenhar circulos na parte inferior
        }
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
}
