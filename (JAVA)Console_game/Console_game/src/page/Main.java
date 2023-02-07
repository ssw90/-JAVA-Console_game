package page;

import java.awt.AWTException;

import db.PlayersDAO;
import db.PlayersDTO;
import method.Set_Audio;
import method.Set_CMD_Init;

public class Main extends Set_page {
	static int result;
	static boolean select;
	static boolean session = false;
	public static String HP;

	public static void main(String[] args) {
		try {
			Set_CMD_Init init = new Set_CMD_Init(); // Set Initializing
			init.run();
			init = null; // delete Init object after initializing
		} catch (InterruptedException | AWTException e) {
			e.printStackTrace();
		}
		while (true) {
			// Login
			while (true) {
				Login login = new Login();
				session = login.run();
				HP = login.loginGetHp();
				if (session == true) {
					try {
						Game_Intro intro = new Game_Intro();
						cls();
						Set_Audio.audioPlay("Login(Ringing_Bell)", 1);
						Thread.sleep(2500);
						result = intro.run();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				} else {
					// 아이디도 없고 비번도없음.(가입절차 진행
					Sign_Intro sign_intro = new Sign_Intro();
					select = sign_intro.run();
					// 가입하시겠습니까? Y일경우
					if (select == true) {
						Sign sign = new Sign();
						select = sign.run();
						// 인증까지 마친뒤
						if (select == true) {
							// 가입완료 메세지 출력
							cls();
							String ANSI_RESET = "\u001B[0m";
							String ANSI_RED = "\u001B[31m";
							String[] str = { "가입 완료." };

							for (int i = 0; i < str[0].length(); i++) {
								System.out.print(ANSI_RED + str[0].substring(i, i + 1) + ANSI_RESET);
							}
							try {
								Thread.sleep(2500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// 가입완료 후 행위
							cls();
							break;
							// 게임 인트로 이동
						} else {
							// 가입 실패시 행위
							// 아이디 밴
					
							// 로그인페이지로 이동
						}
					} else {
						// 가입 거절시 행위
						Set_Audio.audioPlay("shot", 1);
						cls();
						break;
					}
				}
			}
		}
	}
}
