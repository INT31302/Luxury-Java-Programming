import java.util.*;
class Game{
	private Calendar now;
	private Scanner s = new Scanner(System.in);
	private int sec1, sec2, result1, result2;
	public Game() {
		System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
	}
	public void run() {
		System.out.print("황기태 시작 <Enter>키>>");
		s.nextLine();
		now = Calendar.getInstance();
		sec1 = now.get(Calendar.SECOND);
		System.out.println("\t현재 초 시간 = " + sec1);
		System.out.print("10초 예상 후 <Enter>키>>");
		s.nextLine();
		now = Calendar.getInstance();
		sec2 = now.get(Calendar.SECOND);
		System.out.println("\t현재 초 시간 = " + sec2);
		result1 = calc(sec1, sec2);
		
		System.out.print("이재문 시작 <Enter>키>>");
		s.nextLine();
		now = Calendar.getInstance();
		sec1 = now.get(Calendar.SECOND);
		System.out.println("\t현재 초 시간 = " + sec1);
		System.out.print("10초 예상 후 <Enter>키>>");
		s.nextLine();
		now = Calendar.getInstance();
		sec2 = now.get(Calendar.SECOND);
		System.out.println("\t현재 초 시간 = " + sec2);
		result2 = calc(sec1, sec2);
		
		System.out.print("황기태의 결과 " + result1 +","+"이재문의 결과 " + result2+", 승자는 ");
		System.out.println(compare(result1, result2)? "이재문":"황기태");
	}
	
	public int calc(int sec1, int sec2){
		if(sec1<sec2) return sec2-sec1;
		else return (60 - sec1)+sec2;
	}
	
	public boolean compare(int result1, int result2) {
		if(Math.abs(10-result1) >= Math.abs(10-result2)) return true;
		else return false;
	}
}

public class StopGame {
	public static void main(String[] args) {
		Game g = new Game();
		g.run();
	}
}
