package page;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import db.PlayersDAO;
import db.PlayersDTO;
import db.SMS;
import method.Set_Audio;
import method.Set_Position;

public class Sign extends Set_page {
	public boolean run() {
		cls();
		Set_Audio.audioPlay("Sign(Bgsound)", 99);
		Scanner scan = new Scanner(System.in);
		Set_Position position = new Set_Position();
		String HP;
		int cnt = 3;
		int PC;
		int x = 1;
		int y = 1;
		try {
			x = (position.getXposition() / 2);
			y = (position.getYposition() / 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i <= (y - 9); i++) {
			System.out.println();
		}
		showPage("Sign_NameCard");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		HP = Main.HP;
		System.out.println();
		int cert = SMS.sendCert(HP);
		while (true) {
			try {
				cls();
				for (int i = 0; i <= (y - 9); i++) {
					System.out.println();
				}
				showPage("Sign_NameCard2");
				position.SetXYposition(x, y);
				PC = scan.nextInt();
				// db insert
				if (PC == cert) {
					PlayersDTO dto = new PlayersDTO(HP, PC);
					PlayersDAO dao = new PlayersDAO();
					dao.insert(dto);
					Set_Audio.stop();
					return true;
					// 가입
				} else {
					// 인증번호 틀렸을경우.
					cls();
					String ANSI_RESET = "\u001B[0m";
					String ANSI_RED = "\u001B[31m";
					x=position.getXposition()/2;
					y=position.getYposition()/2;
					for(int i =0;i<=y-2;i++) {
						System.out.println(" ");
					}
					
					String[] str = { "잘못된 인증번호 입니다." };

					System.out.printf("%-" + (x-6) + "s", "");
					for (int i = 0; i < str[0].length(); i++) {
						System.out.print(ANSI_RED + str[0].substring(i, i + 1) + ANSI_RESET);
					}
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					cnt--;
					if (cnt == 0) {
						Set_Audio.stop();	
						cls();
						Set_Audio.audioPlay("shot", 1);
						String[] str2 = { "당신은 앞으로 게임에 접근하실 수 없습니다." };
						for(int i =0;i<=y-2;i++) {
							System.out.println(" ");
						}
						System.out.printf("%-" + (x-12) + "s", "");
						for (int i = 0; i < str2[0].length(); i++) {
							System.out.print(ANSI_RED + str2[0].substring(i, i + 1) + ANSI_RESET);
						}
						try {
							Thread.sleep(2500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						PlayersDTO dto = new PlayersDTO(HP, "Y");
						PlayersDAO dao = new PlayersDAO();
						dao.insert(dto);
					
						cls();
						return false;
					}
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
