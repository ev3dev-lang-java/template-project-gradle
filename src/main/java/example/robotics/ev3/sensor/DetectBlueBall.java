package example.robotics.ev3.sensor;

import ev3dev.actuators.Sound;
import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetectBlueBall {

	public static Logger LOGGER = LoggerFactory.getLogger(DetectBlueBall.class);

	private static EV3ColorSensor color1 = new EV3ColorSensor(SensorPort.S1);
	
	private static int HALF_SECOND = 500;
	
	public static void main(String[] args) {

		//Color ID
		LOGGER.info("Switching to Color ID Mode");
		SampleProvider sp = color1.getColorIDMode();
		
		int sampleSize = sp.sampleSize();
		float[] sample = new float[sampleSize];

		int value = 0;

        // Takes some samples and prints them
        for (int i = 0; i < 100; i++) {
        	sp.fetchSample(sample, 0);
			value = (int) sample[0];

			LOGGER.info("N={} Sample={}", i, value);
            
            Delay.msDelay(HALF_SECOND);

			if(value == Color.BLUE){
				Sound.getInstance().beep();
				LOGGER.info("Blue ball found");
				break;
			}
        }

	}

}
