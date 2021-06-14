package Screen;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class musicStuff {
	void playMusic(String musicLocation) {
		try
		{
			File musicPath = new File(musicLocation);
			if (musicPath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath.getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				JOptionPane.showMessageDialog(null,"Press OK to stop playing");
			}
			else
			{
				System.out.println("Can't find file");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
