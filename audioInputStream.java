

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class audioInputStream {
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("mariachi.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = 
				  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
			clip.start();
			gainControl.setValue(-20.0f);
			//music scaling tests
			try {
				Thread.sleep(10000);
				gainControl.setValue(-30.0f);
				Thread.sleep(10000);
				gainControl.setValue(3.0f);
				Thread.sleep(10000);
				gainControl.setValue(-50.0f);//sound completely gone
				Thread.sleep(10000);
				gainControl.setValue(-40.0f);
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gainControl.setValue(6.0206f);//sound max
			
	}

}
