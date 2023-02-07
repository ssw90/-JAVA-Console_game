package page;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import method.Set_Audio;
import method.Set_CMD_Init;
import method.Set_Position;

public class Sign_Intro extends Set_page {
	boolean result;
	public boolean run() {
		cls();
		String[] str = { "저희 회원이 아니시군요", "선생님, 저랑 게임 한판 하시겠습니까??", "'Y' / 'N'" };
		int k;
		int x=0;
		int y=0;
		Scanner scan = new Scanner(System.in);
		try {
			Set_Audio.audioPlay("Sign(Intro_Typing)", 1);
			Set_Position position = new Set_Position();
			x = (position.getXposition() / 2);
			y = (position.getYposition() / 2);
			

//			String ANSI_GREEN = "\u001B[32m";
//			String ANSI_YELLOW = "\u001B[33m";
//			String ANSI_BLUE = "\u001B[34m";
//			String ANSI_PURPLE = "\u001B[35m";
//			String ANSI_CYAN = "\u001B[36m";
			String ANSI_RESET = "\u001B[0m";
			String ANSI_RED = "\u001B[31m";

			for (k = 0; k <= (y - 6); k++) { // position Y initialize
				System.out.println();
			}
			System.out.printf("%-" + (x - (str[0].length() / 2)) + "s", ""); // position X initialize, X=26 Y = 118
																				// length(half) = 6
			for (int i = 0; i < str[0].length(); i++) {
				System.out.print(ANSI_RED + str[0].substring(i, i + 1) + ANSI_RESET);
				Thread.sleep(170); // Set typing speeds
			}
			System.out.println(); // X=27
			System.out.printf("%-" + (x - (str[1].length() / 2) - 3) + "s", ""); // position X initialize //X=28 Y=118
																					// length(half) = 11
			for (int i = 0; i < str[1].length(); i++) {
				System.out.print(ANSI_RED + str[1].substring(i, i + 1) + ANSI_RESET);
				Thread.sleep(160); // Set typing speeds
			}
			System.out.println(); // X=29
			System.out.println(); // X=30
			System.out.printf("%-" + (x - (str[2].length() / 2) + 4) + "s", ""); // position X initialize, X= Y=
																					// length(half) = 4
			for (int i = 0; i < str[2].length(); i++) {
				System.out.print(str[2].substring(i, i + 1));
				Thread.sleep(160); // Set typing speeds
			}
			position.SetXYposition(x+4, y);
			position = null;
			while(true) {
			String result = scan.next();
				if(result.equals("Y")||result.equals("y")) {
					return true;
				}
				else if(result.equals("N")||result.equals("n")) {
					Set_Audio.stop();
					return false;
				}
				else {
					continue;
				}
			}
		} catch (Exception e) {
		}
				return false;// End of Method(sign_Intro)
	}//End of main

}
