import java.util.Scanner;
public class InCircle2 {

	public static void main(String[] args) {
		double x1, x2, y1, y2, radius1, radius2;
		Scanner s = new Scanner(System.in);
		System.out.print("첫번째 원의 중심과 반지름 입력>>");
		x1 = s.nextDouble();
		y1 = s.nextDouble();
		radius1 = s.nextDouble();
		
		System.out.print("두번째 원의 중심과 반지름 입력>>");
		x2 = s.nextDouble();
		y2 = s.nextDouble();
		radius2 = s.nextDouble();

		if(CheckX(x1, x2, radius1) && CheckY(y1, y2, radius2))
			System.out.println("두 원은 서로 겹친다.");
		else
			System.out.println("두 원은 서로 겹치지 않는다.");
	s.close();
	}
	public static boolean CheckX(double x1, double x2, double radius)
	{
		double cir1 = 2 * x1 * 3.141592;
		double cir2 = 2 * x2 * 3.141592;
		if(cir1 >= -cir2 || cir1 <= cir2) return true;
		return false;
	}
	
	public static boolean CheckY(double y1, double y2, double radius)
	{
		double cir1 = 2 * y1 * 3.141592;
		double cir2 = 2 * y2 * 3.141592;
		if(cir1 >= -cir2 || cir1 <= cir2) return true;
		return false;
	}
}
