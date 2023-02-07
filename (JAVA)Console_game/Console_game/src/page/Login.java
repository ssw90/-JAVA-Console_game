package page;

import java.io.IOException;
import java.util.Scanner;

import db.PlayersDAO;
import db.PlayersDTO;
import method.Set_Position;

public class Login extends Set_page {
	public static String hp=null;

	public boolean run() {
		cls();
		PlayersDAO dao = new PlayersDAO();
		Set_Position position = new Set_Position();
		Scanner scan = new Scanner(System.in);
		int pc=0;
		int x=0; 
		int y=0;
		try {
			x = (position.getXposition() / 2);
			y = (position.getYposition() / 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i <= (y - 8); i++) {
			if (i == (y - 10)) {
				System.out.printf("%-" + (x - 6) + "s", "");
				System.out.println("H·P    :"); // Y = 10
				System.out.printf("%-" + (x - 12) + "s", "");
				System.out.println("Personal Code :"); // Y=11
				System.out.println();
			} else {
				System.out.println();
			}
		}

		try {
			showPage("Login(Dial_Pad)");
			position.SetXYposition(x + 3, y - 10);
			hp = scan.next();
			position.SetXYposition(x + 3, y - 9);
			pc = scan.nextInt();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PlayersDTO dto = new PlayersDTO(hp, pc);
		boolean login = dao.login(dto);
		if (login == true) {
			//로그인 성공시 게임인트로 CLASS 호출
			return true;
			
		} else {
			//실패시 로그인호출
			
			boolean chk = dao.hpCheck(hp);
				if(chk==true) {
					cls();
					String ANSI_RESET = "\u001B[0m";
					String ANSI_RED = "\u001B[31m";
					for(int i =0;i<=y-2;i++) {
						System.out.println(" ");
					}
					
					String[] str = { "개인 고유번호 오류입니다." };

					System.out.printf("%-" + (x-7) + "s", "");
					for (int i = 0; i < str[0].length(); i++) {
						System.out.print(ANSI_RED + str[0].substring(i, i + 1) + ANSI_RESET);
					}
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					this.run();
				}
				else {
					return false;
				}
			
		}
		return login;
	}
	
	public String loginGetHp() {
		return hp;
	}
}
