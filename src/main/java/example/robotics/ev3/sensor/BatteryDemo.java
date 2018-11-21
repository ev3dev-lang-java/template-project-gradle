package example.robotics.ev3.sensor;

import ev3dev.sensors.Battery;
import lejos.utility.Delay;

public class BatteryDemo {

	public static void main(String[] args) {

        final Battery battery = Battery.getInstance();

		for(int x = 0; x < 20; x++){
			System.out.println("Battery Voltage: " + battery.getVoltage());

			Delay.msDelay(1000);
		}
	}

}
