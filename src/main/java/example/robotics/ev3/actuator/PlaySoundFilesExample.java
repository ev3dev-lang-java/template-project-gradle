package example.robotics.ev3.actuator;

import ev3dev.actuators.Sound;
import ev3dev.utils.JarResource;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class PlaySoundFilesExample {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        //Sound courtesy: http://www.wavsource.com/video_games/duke_nukem.htm
        String filePath = "ready_4_action.wav";
        String result = JarResource.export(filePath);

        Sound sound = Sound.getInstance();

        File file = new File(result);
        sound.playSample(file);

        JarResource.delete(result);
    }

}
