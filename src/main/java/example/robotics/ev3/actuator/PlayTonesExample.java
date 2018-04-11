package example.robotics.ev3.actuator;

import ev3dev.actuators.Sound;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PlayTonesExample {

	public static Logger LOGGER = LoggerFactory.getLogger(PlayTonesExample.class);

	//Configuration
	private static int MAX_VOLUME = 100;
	private final static int ONE_SECOND = 1000;
	
    private static final int FREQ1	= 300;
    private static final int FREQ2 = 400;
    private static final int variation = 10;
    
	public static void main(String[] args) throws IOException {

		LOGGER.info("Play sound tones");

		Sound sound = Sound.getInstance();

		sound.setVolume(MAX_VOLUME);
		LOGGER.info("Volume: {}", sound.getVolume());

		sound.beep();
		sound.twoBeeps();
		
		Delay.msDelay(ONE_SECOND);

		for(int i = FREQ1; i <= FREQ2; i += variation) {
			sound.playTone(i, 500, 100);
		}
		
		sound.playTone(300, 500);
	}

}
