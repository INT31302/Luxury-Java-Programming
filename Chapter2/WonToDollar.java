import java.util.Scanner;
public class WonToDollar {

	public static void main(String[] args) {
		int won;
		double doller;
		Scanner s = new Scanner(System.in);
		System.out.print("원화를 입력하세요(단위 원)>> ");
		won = s.nextInt();
		doller = won/1100;
		System.out.println(won+"원은 $"+doller+"입니다.");
		s.close();
	}

}
