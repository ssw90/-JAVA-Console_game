package page;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import method.Set_Position;

public class Set_page {

	static int terminalWidth;
	static int terminalHeight;

	/*
	 * 1.Login(Dial_Pad) => 2.Sign(Intro_Typing) => The Typing sound effect when
	 * printing text Page in loading Sign_Intro page 3.Game(Intro_Bgsound) =>
	 * Playing Music(SquidGame_Soldier) when loading Game_Intro page
	 *
	 *
	 *
	 */

	// Start Screen Method
	public static void showPage(String path)  { 	
		int objLength=0;
		int objHeight=0;
		int x=0;
		int y=0;
		
		try {
			Set_Position position = new Set_Position();
			x = (position.getXposition() / 2);
			y = (position.getYposition() / 2);
			position = null;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		switch(path) {
			case "Login(Dial_Pad)":
				path = "Login_Dialpad";
				objLength=30; 
				objHeight=12;
				break;
			case "Game(Intro_Banner)":
				path = "Intro_Banner";
				objLength=90; 	
				objHeight=55;
				break;
			case "Sign_NameCard":
				path = "NameCard";
				objLength=79; 	
				objHeight=23;
				break;
			case "Sign_NameCard2":
				path = "NameCard2";
				objLength=79; 	
				objHeight=23;
				break;
			case "test":
				path = "test";
				objLength=90; 	
				objHeight=55;
				break;
		}		
		
		File file = new File("./"+path+".txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.printf("%-"+(x-(objLength/2))+"s","");
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("text file not found!!");
			e.printStackTrace();
		}
	} //End of Screen Method

	public static void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	// End of CMD_Control Method
}
