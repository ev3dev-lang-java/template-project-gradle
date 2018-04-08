package example.robotics.ev3.sensor;

import ev3dev.sensors.Battery;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Any robot require energy to run.
 * EV3 Brick receive the energy from 2 alternatives:
 *
 * - 6x AA batteries
 * - EV3 Rechargeable DC Battery 45501
 *
 * This example explains how to use the sensor to check the Battery level.
 *
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
