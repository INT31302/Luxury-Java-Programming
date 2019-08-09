import java.util.*;

public class HandGame {
	static void compare(String cs, String co)
	{
		if(cs.equals(co)){
			System.out.println("비겼습니다.");
		}
		else if( (cs.equals("가위") && co.equals("바위")) || (cs.equals("바위") && co.equals("보")) || cs.equals("보") && co.equals("가위") )
			System.out.println("컴퓨터가 이겼습니다.");
		else System.out.println("철수가 이겼습니다.");
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String gbb[] = {"가위", "바위", "보"};
		String cs, co;
		int input, com;
		while(true) {
			System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4) ] >>");
			try {
				input = s.nextInt();
				if(input>0 && input <=4)
				{
					switch(input)
					{
					case 1:
					case 2:
					case 3:
					com = (int)(Math.random()*3);
					cs = gbb[input-1];
					co = gbb[com];
					System.out.println("철수("+cs+") : 컴퓨터("+ co +")");
					compare(cs,co);
					break;
					case 4:
						s.close();
						return;
					}
				}
			}
			catch(Exception e) {s.close(); return;}
		}
	}
}
