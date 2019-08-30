import java.util.*;

class Word{
	String eng, kor;
	public Word(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
	public String getEng() {return eng;}
	public String getKor() {return kor;}
}

public class WordQuiz {
	private Vector<Word> v = new Vector<>();
	private String list[] = new String[4];
	public WordQuiz() {
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
	}
	public void run() {
		
		int input,answer;
		Scanner s = new Scanner(System.in);
		System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 "+ v.size()+"개의 단어가 들어 있습니다.");
		while(true) {
			answer = question();
			input = s.nextInt();
			if(input == -1) {
				System.out.println("\"명품영어\"를 종료합니다...");
				s.close();
				return;
			}
			compare(input, answer);
		}
	}
	
	public int question() {
		int ran = (int)(Math.random()*v.size());
		int cnt = 0;
		String answer = v.get(ran).getKor();
		
		System.out.println(v.get(ran).getEng()+"?");
		
		int r = (int)(Math.random()*4);
		int na = r + 1;
		list[r] = v.get(ran).getKor();
		
		while(true) {
			ran = (int)(Math.random()*v.size());
			r = (int)(Math.random()*4);
			if(list[r] == null){
				if(!v.get(ran).getKor().equals(answer)) {
					list[r] = v.get(ran).getKor();
					cnt++;
				}
			}
			if(cnt==3) break;
		}
		for(int i = 0; i<4; i++){
			System.out.print("("+(i+1)+")"+list[i]+" ");
		}
		System.out.print(":>");
		return na;
	}
	public void compare(int input, int answer) {
		if(input == answer) System.out.println("Excellent !!");
		else System.out.println("No. !!");
		
		for(int i =0; i<4; i++) list[i] = null;
	}
	public static void main(String[] args) {
		WordQuiz wq = new WordQuiz();
		wq.run();
	}
}
