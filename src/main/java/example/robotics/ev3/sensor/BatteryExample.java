package example.robotics.ev3.sensor;

import ev3dev.sensors.Battery;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example explain how to use the internal sensor to check
 * the battery level.
 */
public class BatteryExample {

	public static Logger LOGGER = LoggerFactory.getLogger(BatteryExample.class);

	public static int ONE_SECOND = 1000;

	public static void main(String[] args) {

		Battery battery = Battery.getInstance();

		for(int x = 0; x < 20; x++) {

			LOGGER.info("Battery Voltage: {}", battery.getVoltage());
			Delay.msDelay(ONE_SECOND);
		}
	}

}
