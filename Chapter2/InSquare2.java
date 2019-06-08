import java.util.Scanner;

public class InSquare2 {

	public static void main(String[] args) {
		final int x1 = 100;
		final int x2 = 200;
		final int y1 = 100;
		final int y2 = 200;
		int x3,y3,x4,y4;
		
		Scanner s = new Scanner(System.in);
		System.out.print("두 점 (x,y)의 좌표를 입력하시오>>");
		x3 = s.nextInt();
		y3 = s.nextInt();
		x4 = s.nextInt();
		y4 = s.nextInt();
		s.close();
		if(check_x(x3,x4,x1,x2) && check_y(y3,y4,y1,y2))
		{
			System.out.println("("+x3+","+y3+"),("+x3+","+y3+")는 사각형 안에 있습니다.");
		}
		else System.out.println("("+x3+","+y3+"),("+x3+","+y3+")는 사각형 안에 없습니다.");
		
	}
	
	public static boolean check_x(int x1, int x2, int rectx1, int rectx2)
	{
		if( x1>=rectx1 && x1<=rectx2 || x2>=rectx1 && x2<=rectx2 ) return true;
		else return false;
	}

	public static boolean check_y(int y1, int y2, int recty1, int recty2)
	{
		if( y1>=recty1 && y1<=recty2 || y2>=recty1 && y2<=recty2 ) return true;
		else return false;
	}
}
