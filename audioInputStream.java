package dap;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class audioInputStream {
	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
		  new File("mariachi.wav"));
	Clip clip = AudioSystem.getClip();
	clip.open(audioInputStream);
	FloatControl gainControl = 
		  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	clip.start();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
