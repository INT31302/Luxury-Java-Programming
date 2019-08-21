import java.util.*;

public class CntStringToken {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringTokenizer st;
		String Words;
		int cnt;
		while(true)
		{
			System.out.print(">>");
			Words = s.nextLine();
			if(Words.equals("그만")) {
				System.out.println("종료합니다...");
				s.close();
				return;
			}
			st = new StringTokenizer(Words, " ");
			cnt = st.countTokens();
			System.out.println("어절 개수는 " + cnt);
		}
		
	}
}
