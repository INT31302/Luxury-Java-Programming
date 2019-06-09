import java.util.Scanner;

public class InCircle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double CircleX, CircleY, DotX, DotY, Radius;
		System.out.print("원의 중심과 반지름 입력>> ");
		CircleX = s.nextDouble();
		CircleY = s.nextDouble();
		Radius = s.nextDouble();
		
		System.out.print("점 입력>> ");
		DotX = s.nextDouble();
		DotY = s.nextDouble();
		if(CheckX(CircleX,DotX) && CheckY(CircleY, DotY))
		{
			System.out.println("점 ("+DotX+","+DotY+")는 원 안에 있습니다.");
		}
		else System.out.println("점 ("+DotX+","+DotY+")는 원 안에 없습니다.");
		
		s.close();
	}
	
	public static boolean CheckX(double CircleX, double DotX)
	{
		double x = 6.5*2 + CircleX;
		if (DotX >= -x && DotX <= x) return true;
		else return false;
	}
	
	public static boolean CheckY(double CircleY, double DotY)
	{
		double y = 6.5*2 + CircleY;
		if (DotY >= -y && DotY <= y) return true;
		else return false;
	}
}
