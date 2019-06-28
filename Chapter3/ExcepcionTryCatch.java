import java.util.*;

public class ExcepcionTryCatch {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("곱하고자 하는 두 수 입력>>");
		try {
			int n = s.nextInt();
			int m = s.nextInt();
			System.out.println(n + "x" + m +"=" + n*m );
		}
		catch(InputMismatchException e) {
			System.out.println("실수는 입력하면 안됩니다.");
			s.nextLine();
		}
		s.close();
	}
}
