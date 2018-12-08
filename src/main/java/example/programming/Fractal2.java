package example.programming;

import ev3dev.actuators.LCD;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.robotics.Color;
import lejos.utility.Delay;

import java.util.Random;

public class Fractal2 {
   
      public static void main(String args[]) {
           new Fractal2();
      }  
   
      public Fractal2() {

          GraphicsLCD g2d = LCD.getInstance();

           g2d.setColor(Color.WHITE);
           g2d.fillRect(0, 0, 178, 128);
           g2d.refresh();
           generateTreeFractal(g2d, 178 / 2, 128 / 2, 10, 20);

      }  
   
      private static Color brightness(Color c, double scale) {  
           int r = Math.min(255, (int) (c.getRed() * scale));  
           int g = Math.min(255, (int) (c.getGreen() * scale));  
           int b = Math.min(255, (int) (c.getBlue() * scale));  
           return new Color(r, g, b);  
      }  
   
      private void generateTreeFractal(GraphicsLCD g2d, double x, double y,
                double lineWidth, double lineLength) {  
   
           // multipliers for recursion. Must be between 0 and 1  
           // WARNING: the closer these are to 1 the longer the run time will be  
           final double LINE_WIDTH_MULTILIER = .80;  
           final double LINE_LENGTH_MULTIPLIER = .85;  
   
           // base case - we need to stop somewhere  
           // or else we'll get a stack overflow  
           if (lineWidth <= 1 || lineLength <= 2) {  
                return;  
           }  
   
           Random rand = new Random();
   
           // compute random number of lines to draw. Play with this.  
           int numOfLinesToDraw = 1 + rand.nextInt(4);  
   
           //BasicStroke bs = new BasicStroke((float) lineWidth,
           //          BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
           //g2d.setStroke(bs);
           //g2d.setColor(Color.gray);
   
           // mess with the color  
           //Color c = g2d.getColor();
           // need a number from 0-1 to scale the color... I made this equation up  
           // it gives a cool shaded almost 3d effect. This should be played with  
           // to get better looking effects  
           //c = brightness(
           //          c,
           //          Math.abs(Math.cos(x * x + y * y + lineWidth * lineWidth
           //                    + lineLength * lineLength)));
           g2d.setColor(Color.BLACK);
   
           // draw lines  
           for (int i = 0; i < numOfLinesToDraw; i++) {  
                // first calculate random positive vector  
                double x1 = rand.nextDouble() - .5;  
                double y1 = rand.nextDouble() - .5;  
   
                // divide by magnitude so we get a unit vector  
                double mag = Math.sqrt(x1 * x1 + y1 * y1);  
                x1 = x1 / mag;  
                y1 = y1 / mag;  
   
                // scale by lineLength  
                x1 = x1 * lineLength;  
                y1 = y1 * lineLength;  
   
                // move to center  
                x1 = x1 + x;  
                y1 = y1 + y;  
   
                // now (x1,y1) represents point on circle with radius lineLength and  
                // centered around (x,y)  
                g2d.drawLine((int) x, (int) y, (int) x1, (int) y1);
                g2d.refresh();

                Delay.msDelay(1000);

                // now recurse  
                generateTreeFractal(g2d, x1, y1, lineWidth * LINE_WIDTH_MULTILIER,  
                          lineLength * LINE_LENGTH_MULTIPLIER);  
   
           }  
   
      }  
   
 }  
