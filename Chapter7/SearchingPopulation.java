import java.util.*;

public class SearchingPopulation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap <> ();
		String name;
		int cnt;
		System.out.println("나라 이름과 인구를 입력하세요. (예: Korea 5000)");
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			name = s.next();
			if(name.equals("그만")) break;
			cnt = s.nextInt();
			nations.put(name, cnt);
		}
		while(true) {
			System.out.print("인구 검색 >> ");
			name = s.next();
			if (name.equals("그만")) {
				s.close();
				return;
			}
			if(nations.containsKey(name)) System.out.println(name +"의 인구는 "+ nations.get(name));
			else System.out.println(name +" 나라는 없습니다.");
		}
	}
}
