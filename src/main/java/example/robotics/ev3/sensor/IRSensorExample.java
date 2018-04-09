package example.robotics.ev3.sensor;

import ev3dev.sensors.Battery;
import ev3dev.sensors.ev3.EV3IRSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IRSensorExample {

	public static Logger LOGGER = LoggerFactory.getLogger(IRSensorExample.class);

	private static EV3IRSensor ir1 = new EV3IRSensor(SensorPort.S1);

	private static int HALF_SECOND = 500;
	
	public static void main(String[] args) {

		final SampleProvider sp = ir1.getDistanceMode();
		int distanceValue = 0;

		//Control loop
		final int iteration_threshold = 50;
		for(int i = 0; i <= iteration_threshold; i++) {
		
			float [] sample = new float[sp.sampleSize()];
		    sp.fetchSample(sample, 0);
		    distanceValue = (int)sample[0];

            LOGGER.info("Iteration: {}, Distance: {}", i, distanceValue);

		    Delay.msDelay(HALF_SECOND);
		}

        LOGGER.info("Battery voltage: {}", Battery.getInstance().getVoltage());

	}

}
