package method;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Set_Audio {
	// define storage for start position
	public static Clip clip;
	// get the clip status
	public static AudioInputStream audioStream;
	// initialize both the clip and streams
	public static void audioPlay(String currentPage, int rotate ) {

		
		if (currentPage.equals("Login(Ringing_Bell)")) { // 1
			currentPage = "./sound/ringing_Sound.wav";
			rotate = rotate-1;
		} else if (currentPage.equals("Sign(Intro_Typing)")) { // 2
			currentPage = "./sound/typing_Sound.wav";
			rotate = rotate-1;
		} else if (currentPage.equals("Game(Intro_Bgsound)")) { // 3
			currentPage = "./sound/intro_Music.wav";
			rotate = rotate-1;
		} else if (currentPage.equals("Sign(Bgsound)")) { // 4
			currentPage = "./sound/music_Soldier.wav";
			rotate = rotate-1;
		}
		else if(currentPage.equals("shot")) {
			currentPage="./sound/gun_Shot.wav";
		}
		else if(currentPage.equals("game1")) {
			currentPage="./sound/doll_Saying.wav";
		}
		try {
			// the input stream object
			audioStream = AudioSystem.getAudioInputStream(new File(currentPage).getAbsoluteFile());
			// the reference to the clip
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.loop(rotate);
			play();
		} catch (Exception e) {
			System.out.println("PlayAudio Error!");
			e.printStackTrace();
		}
	}

	// play
	
	public static void play() {
		if(clip.isRunning()==false) {
			clip.start();
		}
	}
	public static void stop() {
		if(clip.isRunning()==true) {
			clip.stop();
		}
	}
}
