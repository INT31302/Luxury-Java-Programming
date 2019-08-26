import java.util.*;

class Nation {
	private String Country, Capital;
	public Nation(String Country, String Capital) {this.Country = Country; this.Capital = Capital;}
	public String getCountry() {return Country;}
	public String getCapital() {return Capital;}
}
public class Capital_Quiz {
	private Scanner scanner = new Scanner(System.in);
	private Vector<Nation> v = new Vector<>();
	public Capital_Quiz() {
		v.add(new Nation("멕시코", "멕시코시티"));
		v.add(new Nation("스페인", "리스본"));
		v.add(new Nation("프랑스", "파리"));
		v.add(new Nation("영국", "런던"));
		v.add(new Nation("그리스", "아테네"));
		v.add(new Nation("독일", "베를린"));
		v.add(new Nation("일본", "동경"));
		v.add(new Nation("중국", "베이징"));
		v.add(new Nation("러시아", "모스크바"));
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
	}
	public void insert() {
		String Country, Capital;
		
		System.out.println("현재 " + v.size()+"개 나라와 수도가 입력되어 있습니다.");
		while(true) {
			boolean check = false;
			System.out.print("나라와 수도 입력"+(v.size()+1)+">>" );
			Country = scanner.next();
			if(Country.equals("그만")) return;
			Capital = scanner.next();
			Nation n = new Nation(Country,Capital);
			for(int i =0; i<v.size(); i++) {
				if(v.get(i).getCountry().equals(Country)) {
					System.out.println(Country+"는 이미 있습니다!");
					check = true;
					break;
				}
			}
			if(check == false) v.add(n);
		}
	}
	public void quiz() {
		String answer;
		while(true)
		{
			int ran = (int)(Math.random()*v.size());
			System.out.print(v.get(ran).getCountry()+"의 수도는? ");
			answer = scanner.next();
			if(answer.equals("그만")) return;
			if(answer.equals(v.get(ran).getCapital())) System.out.println("정답!!");
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
			catch(Exception e) {
				
			}
		}
	}
	public static void main(String[] args) {
		Capital_Quiz cq = new Capital_Quiz();
		cq.run();
	}
}
