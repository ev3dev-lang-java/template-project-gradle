package example.robotics.ev3.sensor;

import ev3dev.sensors.Battery;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USSensorExample {

	public static Logger LOGGER = LoggerFactory.getLogger(USSensorExample.class);

	private static EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S1);

	public static void main(String[] args) {

		final SampleProvider sp = us1.getDistanceMode();
		int distanceValue = 0;

        final int iteration_threshold = 100;
        for(int i = 0; i <= iteration_threshold; i++) {

        	float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            distanceValue = (int) sample[0];

			LOGGER.info("Iteration: {}, Distance: {}", i, distanceValue);

			Delay.msDelay(500);
        }

		LOGGER.info("Battery voltage: {}", Battery.getInstance().getVoltage());

	}

}
