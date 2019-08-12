import java.util.*;

class Modify{
	private Scanner s = new Scanner(System.in);
	private StringBuffer sb;
	private StringTokenizer st1, st2;
	private String Word1, Word2;
	private boolean find;
	public Modify() {
		System.out.print(">>");
		sb = new StringBuffer(s.nextLine());
	}
	
	public void run() {
		try {
			while(true) {
				st1 = new StringTokenizer(sb.toString(), " ");
				System.out.print("명령: ");
				st2 = new StringTokenizer(s.nextLine(), "!");
				Word2 = st2.nextToken();
				if(Word2.equals(" ")) {
					System.out.println("잘못된 명령입니다!");
					continue;
				}
				if(Word2.equals("그만")) {
					System.out.println("종료합니다.");
					s.close();
					return;
				}
				int cnt = 0;
				find = false;
				for(int i =0; i<st1.countTokens(); i++)
				{
					Word1 = st1.nextToken();
					
					if(Word1.equals(Word2)) {
						if(i == 0) sb.replace(0, Word1.length(), st2.nextToken());
						else sb.replace(cnt, Word1.length() + cnt, st2.nextToken());
						sb.setLength(sb.length());
						System.out.println(sb);
						find = true;
						break;
					}
					cnt+=Word1.length() + 1;
				}
				if(!find) System.out.println("찾을 수 없습니다!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
public class ReplaceWord {
	public static void main(String[] args) {
		Modify m = new Modify();
		m.run();
	}
}
