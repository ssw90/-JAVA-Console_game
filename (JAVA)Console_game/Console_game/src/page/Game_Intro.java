package page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import db.PlayersDAO;
import game.game1;
import method.Set_Audio;
import method.Set_Position;

public class Game_Intro extends Set_page {
	int result = 0;
	boolean session = Main.session;

	public int run() {
		try {
			while (true) {
				cls();
				Set_Audio.audioPlay("Game(Intro_Bgsound)",99);
				Scanner scan = new Scanner(System.in);
				Set_Position position = new Set_Position();
				int x = (position.getXposition() / 2);
				int y = (position.getYposition() / 2);
				position = null;
				boolean status;
				ArrayList<String> menu = new ArrayList<>(Arrays.asList("1.게임 시작", "2.랭킹 확인", "3.게임 종료"));

				for (int i = 0; i <= 1; i++) {
					if (i == 0) {
						showPage("Game(Intro_Banner)");
						System.out.printf("%-" + (x - (menu.size() / 2) - 4) + "s", "");
						System.out.println(menu.get(0));
						System.out.println();
						System.out.printf("%-" + (x - (menu.size() / 2) - 4) + "s", "");
						System.out.println(menu.get(1));
						System.out.println();
						System.out.printf("%-" + (x - (menu.size() / 2) - 4) + "s", "");
						System.out.println(menu.get(2));
						System.out.print("입력>>");
					} else {
						System.out.println();
					}

					result = scan.nextInt();

					if (result == 1) {
						//  게임시작을 원한다.
						game1 game =  new game1();
						cls();
						Set_Audio.stop();
						status = game.run();
						if(status == true) {
							//승리하였음.(DB에 추가)
							continue;
						}else {
							continue;
						}
					} else if (result == 2) {
						PlayersDAO dao = new PlayersDAO();
						// 2번 선택시 특정 라인 지우고 1.전체선택 2.개인 랭크 검색 3.돌아가기 메뉴 출력하기
						cls();
						while (true) {
							showPage("Game(Intro_Banner)");
							System.out.printf("\n\n");
							System.out.println("1.전체 랭킹");
							System.out.println("");
							System.out.println("2.뒤로 가기.");
							System.out.print("입력>>");
							result = scan.nextInt();
							if (result == 1) {
								System.out.println("===============전체 랭킹===============");
								System.out.println("Player Number\tWon\tNAME");
								System.out.println("===================================");
								dao.selectAllRank();
								System.out.print("입력>>");
								result=scan.nextInt();
							} else if (result == 2) {
								cls();
								Set_Audio.stop();
								this.run();
								break;
							}
						}
					} else if (result == 3) {
						System.exit(0);
					}
				}
				result = scan.nextInt();
			} // End of while loop
		} catch (Exception e) {

		}
		return 0;
	}
}
