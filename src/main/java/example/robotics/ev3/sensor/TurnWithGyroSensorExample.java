package example.robotics.ev3.sensor;

import ev3dev.actuators.Sound;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TurnWithGyroSensorExample {

	private static final Logger LOGGER = LoggerFactory.getLogger(TurnWithGyroSensorExample.class);

	private static EV3GyroSensor gyroSensor = new EV3GyroSensor(SensorPort.S1);

	private static int HALF_SECOND = 500;
	private static int LOOP_LIMIT = 100;

	public static void main(String[] args) {

		gyroSensor.reset();
		final SampleProvider sp = gyroSensor.getAngleMode();
		int value = 0;

		int iterationCounter = 0;

        //Control loop
		while (true) {

			float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            value = (int)sample[0];

			LOGGER.info("Gyro angle: {}", value);

			if(value >= 90){
				Sound.getInstance().beep();
				LOGGER.info("Rotated 90 degrees");
				break;
			}

			//Avoid an infinite loop
			iterationCounter++;
			if (iterationCounter >= LOOP_LIMIT) {
				LOGGER.debug("Breaking the loop if you didn't rotate in 100 iterations");
				break;
			}

			Delay.msDelay(HALF_SECOND);
		}

	}

}
