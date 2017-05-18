import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by taylor hudson on 1/5/2017.
 */

public class driver {
    public static void main(String [] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    	/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	double width = screenSize.getWidth();
    	double height = screenSize.getHeight();
    	String w = "width = " + width;
    	String h = "height = " + height;
        System.out.println(w);
        System.out.println(h);*/
        graphics testCase = new graphics();
        //Screen dick = new Screen();
        //dick.vicks();
        (new Thread(testCase)).start();
        //http://stackoverflow.com/questions/953598/audio-volume-control-increase-or-decrease-in-java
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("mariachi.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
			  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		clip.start();
		System.out.println("bruh");
		while(testCase.isRunningDriver()){
			musicProx(testCase, gainControl);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("isRunning");
		}
		clip.close();
    }
    public static void musicProx(graphics testCase, FloatControl gainControl){
		int minDist = testCase.getclosestG();
		if(minDist > 600){
			gainControl.setValue(-50.0f);
		}
		else if(minDist > 550 && minDist <= 600){
			gainControl.setValue(-30.0f);
		}
		else if(minDist > 500 && minDist <= 550){
			gainControl.setValue(-20.0f);
		}
		else if(minDist > 450 && minDist <= 500){
			gainControl.setValue(-15.0f);
		}
		else if(minDist > 400 && minDist <= 450){
			gainControl.setValue(-10.0f);
		}
		else if(minDist > 300 && minDist <= 400){
			gainControl.setValue(-5.0f);
		}
		else if(minDist > 200 && minDist <= 300){
			gainControl.setValue(1.0f);
		}
		else if(minDist > 100 && minDist <= 200){
			gainControl.setValue(3.0f);
		}
		else if(minDist > 0 && minDist <= 100){
			gainControl.setValue(6.0f);
		}
	}
}
