package example.robotics.ev3.sensor;

import ev3dev.sensors.Battery;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatteryDemo {

	public static Logger LOGGER = LoggerFactory.getLogger(BatteryDemo.class);

	public static void main(String[] args) {

        final Battery battery = Battery.getInstance();

		for(int x = 0; x < 10; x++){
			LOGGER.info("Battery Voltage: {}", battery.getVoltage());

			Delay.msDelay(100);
		}
	}

}
