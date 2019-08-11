import java.util.*;
class Game{
	private Scanner s = new Scanner(System.in);
	private String list[] = new String[2];
	private int iList[] = new int[3];
	public Game() {
		for(int i =0; i<list.length; i++){
			System.out.print((i+1)+"번째 선수 이름>>");
			list[i] = s.next();
		}
	}
	public void run() {
		int cnt = 0;
		while(true) {
			System.out.print(list[cnt]+":");
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
				if(cnt == 1) cnt = 0;
				else cnt = 1;
			}
		}
	}
}
public class SameNumGame {
	public static void main(String[] args) {
		Game g = new Game();
		g.run();
	}
}
