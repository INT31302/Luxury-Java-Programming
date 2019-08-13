 import java.util.Scanner;
 class Game{
 	private Scanner s = new Scanner(System.in);
 	private String list[];
 	private int iList[] = new int[3];
 	public Game() {
 		System.out.print("겜블링 게임에 참여할 선수 숫자>>");
 		list = new String[s.nextInt()];
 		for(int i =0; i<list.length; i++){
 			System.out.print((i+1)+"번째 선수 이름>>");
 			list[i] = s.next();
 		}
 	}
 	public void run() {
 		int cnt = 0;
 		while(true) {
 			System.out.println(list[cnt]+":");
 			s.nextLine();
 			System.out.print("\t");
 			for(int i = 0; i<iList.length; i++)
 			{
 				iList[i] = (int)(Math.random()*3+1);
 				System.out.print(iList[i]+"\t");
 			}
 			if(iList[0] == iList[1] && iList[1] == iList[2]) {
 				System.out.println(list[cnt]+"님이 이겼습니다.");
 				return;
 			}
 			else {
 				System.out.println("아쉽군요!");
 				if(cnt == list.length-1) cnt = 0;
 				else cnt++;
 			}
 		}
 	}
 }

public class GamblingGame {
	public static void main(String[] args) {
		Game g = new Game();
		g.run();
	}
}
