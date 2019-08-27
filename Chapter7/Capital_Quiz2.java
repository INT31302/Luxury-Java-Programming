import java.util.*;


public class Capital_Quiz2 {
	private HashMap<String,String> map = new HashMap<>();
	private Scanner scanner = new Scanner(System.in);
	public Capital_Quiz() {
		map.put("멕시코", "멕시코시티");
		map.put("스페인", "리스본");
		map.put("프랑스", "파리");
		map.put("영국", "런던");
		map.put("그리스", "아테네");
		map.put("독일", "베를린");
		map.put("일본", "동경");
		map.put("중국", "베이징");
		map.put("러시아", "모스크바");
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
	}
	public void insert() {
		System.out.println("현재 " + map.size()+"개의 나라와 수도가 입력되어 있습니다.");
		String Country, Capital;
		while(true) {
			System.out.print("나라와 수도 입력" + (map.size()+1)+"> >");
			Country = scanner.next();
			if(Country.equals("그만")) return;
			Capital = scanner.next();
			if(map.containsKey(Country)) System.out.println(Country+"는 이미 있습니다!");
			else map.put(Country, Capital);
		}
	}
	public void quiz() {
		while(true) {
			String Country = "", Capital = "", answer;
			int ran = (int)(Math.random()*map.size());
			Set<String> keys = map.keySet();
			Iterator<String> it = keys.iterator();
			int i = 0;
			while(i<=ran) {
				Country =it.next();
				i++;
			}
			Capital = map.get(Country);
			System.out.print(Country + "의 수도는? ");
			answer = scanner.next();
			if(answer.equals("그만")) return;
			if(answer.equals(Capital)) System.out.println("정답!!");
			else System.out.println("아닙니다!!");
		}
	}
	public void run() {
		int menu;
		while(true) {
			System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
			try{
				menu = scanner.nextInt();
				switch(menu) {
				case 1:
					insert();
					break;
				case 2:
					quiz();
					break;
				case 3:
					System.out.println("게임을 종료합니다.");
					scanner.close();
					return;
				}
			}
			catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		Capital_Quiz cq = new Capital_Quiz();
		cq.run();
	}
}
