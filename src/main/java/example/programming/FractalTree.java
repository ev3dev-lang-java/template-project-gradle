package example.programming;

import ev3dev.actuators.LCD;
import lejos.hardware.lcd.GraphicsLCD;

public class FractalTree {

    private GraphicsLCD g;

    public FractalTree() {
        g = LCD.getInstance();
    }
 
    public void drawTree(int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(x2, y2, angle - 20, depth - 1);
        drawTree(x2, y2, angle + 20, depth - 1);
    }

    public static void main(String[] args) {
        FractalTree fractal = new FractalTree();
        fractal.drawTree( 178, 128, -90, 9);
    }
}
