import java.util.Scanner;

public class InSquare {

	public static void main(String[] args) {
		final int x1 = 100;
		final int x2 = 200;
		final int y1 = 100;
		final int y2 = 200;
		int x3,y3;
		Scanner s = new Scanner(System.in);
		System.out.print("점 (x,y)의 좌표를 입력하시오>>");
		x3 = s.nextInt();
		y3 = s.nextInt();
		if( (x3 >= x1 && x3 <= x2) && (y3>= y1 && y3 <= y2) )
		{
				System.out.println("("+x3+","+y3+")는 사각형 안에 있습니다.");
		}
		else System.out.println("("+x3+","+y3+")는 사각형 안에 없습니다.");
		s.close();
	}

}
