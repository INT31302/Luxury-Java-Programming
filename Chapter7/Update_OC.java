import java.util.*;

class Word{
	String kor, eng;
	public Word(String eng, String kor) {this.eng = eng; this.kor = kor;}
	public String getKor() {return kor;}
	public String getEng() {return eng;}
}

public class Update_OC {
	private Vector<Word> v = new Vector<>();
	private Scanner s = new Scanner(System.in);
	private Iterator<Word> it;
	public Update_OC() {
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "꿀"));
		v.add(new Word("dall", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
		System.out.println("**** 영어 단어 테스트 프로그램 \"명품영어\"입니다. ****");
	}
	public void test() {
		System.out.println("현재 "+ v.size()+"개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
		while(true) {
			String eng, kor;
			int answer, cnt=0;
			try {
				String List[] = new String[4];
				int random = (int)(Math.random()*v.size());			
				eng = v.get(random).getEng();
				kor = v.get(random).getKor();
				System.out.println(eng+"?");
				random = (int)(Math.random()*4);
				List[random]= kor;
				while(true) {
					random = (int)(Math.random()*4);
					if(List[random] == null) {
						int random2 = (int)(Math.random()*v.size());
						List[random] = v.get(random2).getKor();
						cnt++;
					}
					if(cnt==3) break;
				}
				
				for(int i =1; i<5; i++) {
					System.out.print("("+i+")"+List[i-1]+" ");
				}
				System.out.print(":>");
				answer = s.nextInt();
				if(answer == -1) return;
				if(List[answer-1].equals(kor)) System.out.println("Excellent !!");
				else System.out.println("No. !!");
			}
			catch(Exception e) {s.close(); return;}
		}
	}
	public void insert() {
		String kor,eng;
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		while(true) {
			boolean check = false;
			System.out.print("영어 한글 입력 >> ");
			eng = s.next();
			if(eng.equals("그만")) return;
			kor = s.next();
			it = v.iterator();
			while(it.hasNext()) {
				if(it.next().getEng().equals(eng)) {System.out.println("이미 등록된 단어입니다.");  check = true; break;}
			}
			if(!check) v.add(new Word(eng,kor));
		}
	}
	public void run() {
		int menu;
		while(true) {
			System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3>> ");
			try {
				menu = s.nextInt();
				switch(menu) {
				case 1:
				test();
				break;
				case 2:
				insert();
				break;
				case 3:
					System.out.println("\"명품영어\"를 종료합니다.");
					s.close();
					return;
				}
			}
			catch(Exception e) {
				System.out.println("오류가 발생하였습니다. 프로그램을 종료합니다.");
				s.close();
				return;
			}
		}
	}
	public static void main(String[] args) {
		Update_OC uoc = new Update_OC();
		uoc.run();
	}
}
