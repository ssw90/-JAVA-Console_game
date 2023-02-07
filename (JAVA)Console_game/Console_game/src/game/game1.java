package game;

import java.util.Random;
import java.util.Scanner;

import method.Set_Audio;
import page.Main;
import page.Set_page;

public class game1  extends Set_page{

	
public static void gameTimer() {
	try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
		
	public boolean run() {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		boolean status;
		String user = "└(◆.◆)┘ <-YOU";
		String user1 = "└(☆.★)┘!! <-YOU";
		String user2 = "\\ \\ \\└(>.<)┘/ / /승리의 세레머뉘 <-YOU";
		String die = "으악( T0T) 탕 탕 탕 <================================================";
		int life = 1;
		int score = 0;
		int distance = 0; // MAX=70;
		while (true) {
			
			int ran = random.nextInt(2)+1;
			
			System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.println("                                                                    ================");
	    	 System.out.println("                                                                    무궁화 꽃이 피었습니다!");
	    	 System.out.println("                                                                    ================");
	    	 System.out.println("                                                                    \t\t\t    "+"／￣￣＼\r\n"
		     		+ "                                                                                       "+"    ｜//////｜\r\n"
		     		+ "                                                                                          ●｜//////｜●\r\n"
		     		+ "                                                                                       ／  ｜//////｜  ＼\r\n"
		     		+ "                                                                                            ＼////／\r\n"
		     		+ "                                                                                              ￣￣\r\n"
		     		+ "                                                                                          ／￣￣￣￣＼\r\n"
		     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
		     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
		     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
		     		+ "                                                                                          ￣￣￣￣￣￣\r\n"
		     		+ "                                                                                           ／      ＼\r\n"
		     		+ "                                                                                          ｜        ｜\r\n"
		     		+ "                                                                                          ｜        ｜\r\n"
		     		+ "                                                                                           ￣￣￣￣￣\r\n"
		     		+ "                                                                                             ｜｜｜｜\r\n");
	    	 		System.out.printf("%-" + (10+distance) + "s", user);
	    	 		System.out.println("                                                                              ｜｜｜｜");
	    	 		System.out.println("==============================================================================================￣  ￣===========");
	    	 		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	    	 		Set_Audio.stop();
	    	 System.out.println();
	    	 System.out.println();
		     System.out.println("                                          [1]이동 [2]제자리");
		     System.out.println("                                          남은수명 : " + (life));
		     System.out.println("                                             점수 : " + (score));
		     System.out.println("                                            User : "+Main.HP);
		     System.out.println();
		     System.out.print("                                              입력>>");
		     Set_Audio.audioPlay("game1",0);
		    
		     int i = scan.nextInt(); 
		     gameTimer();
		     cls();
		     if (i == 1 && ran == 1) {
		    	 
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                        누가 움직여!!");
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                    \t\t\t    "+"／￣￣＼\r\n"
			     		+ "                                                                                       "+"    ｜//////｜\r\n"
			     		+ "                                                                                       ●｜○   ○ ｜●\r\n"
			     		+ "                                                                                       ／  ｜ └─┘  ｜  ＼\r\n"
			     		+ "                                                                                            ＼    ／\r\n"
			     		+ "                                                                                              ￣￣\r\n"
			     		+ "                                                                                          ／￣￣￣￣＼\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                          ￣￣￣￣￣￣\r\n"
			     		+ "                                                                                           ／      ＼\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                           ￣￣￣￣￣\r\n"
			     		+ "                                                                                             ｜｜｜｜\r\n"
			     		+ "   " +  user1  + "                                                                         ｜｜｜｜       \r\n"
			     		+ "==============================================================================================￣  ￣===========\r\n"
			     		+ "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		    	 System.out.println("                                   <술래가 앞을 바라봤다!!> ");
		    	 --life;
		    	 gameTimer();
			     cls();
		     }
		     
		     if ((i == 2 && ran == 1) || (i == 2 && ran == 2) || (i == 1 && ran == 2)) {
		    	 
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                        잘도 피했군..");
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                    \t\t\t    "+"／￣￣＼\r\n"
			     		+ "                                                                                       "+"    ｜//////｜\r\n"
			     		+ "                                                                                       ●｜○   ○ ｜●\r\n"
			     		+ "                                                                                       ／  ｜ └─┘  ｜  ＼\r\n"
			     		+ "                                                                                            ＼    ／\r\n"
			     		+ "                                                                                              ￣￣\r\n"
			     		+ "                                                                                          ／￣￣￣￣＼\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                          ￣￣￣￣￣￣\r\n"
			     		+ "                                                                                           ／      ＼\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                           ￣￣￣￣￣\r\n"
			     		+ "                                                                                             ｜｜｜｜\r\n"
			     		+ "   " +  user2  + "                                               ｜｜｜｜       \r\n"
			     		+ "==============================================================================================￣  ￣===========\r\n"
			     		+ "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		    	 System.out.println("                           <술래의 눈을 피했다!!> ");
		    	 score += 1;
		    	 distance+=1;
		    	 gameTimer();
			     cls();
		     }

		     if(life==0) {
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                        죽어라 인간    ");
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                    \t\t\t    "+"／￣￣＼\r\n"
			     		+ "                                                                                       "+"    ｜//////｜\r\n"
			     		+ "                                                                                       ●｜○   ○ ｜●\r\n"
			     		+ "                                                                                       ／  ｜ └─┘  ｜  ＼\r\n"
			     		+ "                                                                                            ＼    ／\r\n"
			     		+ "                                                                                              ￣￣\r\n"
			     		+ "                                                                                          ／￣￣￣￣＼\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                          ￣￣￣￣￣￣\r\n"
			     		+ "                                                                                           ／      ＼\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                           ￣￣￣￣￣\r\n"
			     		+ "                                                                                             ｜｜｜｜\r\n"
			     		+ "   " +  die   + "                                                                            ｜｜｜｜       \r\n"
			     		+ "==============================================================================================￣  ￣===========\r\n"
			     		+ "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		    	 System.out.println("                                        <당신은 사망하였습니다>");
		    	 Set_Audio.audioPlay("shot",0);
		    	 gameTimer();
			     cls();
			     distance++;
			     status=false;
			     return status;
		}
		     
		 if(score==3) {
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                      운이 좋은 인간이네..       ");
		    	 System.out.println("                                                                    ================");
		    	 System.out.println("                                                                    \t\t\t    "+"／￣￣＼\r\n"
			     		+ "                                                                                       "+"    ｜//////｜\r\n"
			     		+ "                                                                                       ●｜○   ○ ｜●\r\n"
			     		+ "                                                                                       ／  ｜ └─┘  ｜  ＼\r\n"
			     		+ "                                                                                            ＼    ／\r\n"
			     		+ "                                                                                              ￣￣\r\n"
			     		+ "                                                                                          ／￣￣￣￣＼\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                         ｜ ｜    ｜ ｜\r\n"
			     		+ "                                                                                          ￣￣￣￣￣￣\r\n"
			     		+ "                                                                                           ／      ＼\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                          ｜        ｜\r\n"
			     		+ "                                                                                           ￣￣￣￣￣\r\n"
			     		+ "                                                                                             ｜｜｜｜\r\n"
			     		+ "   " +  user2  + "                                                                                 ｜｜｜｜       \r\n"
			     		+ "==============================================================================================￣  ￣===========\r\n"
			     		+ "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		    	 System.out.println("                                        <당신은 승리자!!!!!!! >");
		    	 gameTimer();
			     cls();
			     status=true;
			     return status;
		    	 
		 }
		     }

	}

}
