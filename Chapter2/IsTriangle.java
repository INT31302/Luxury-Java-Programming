import java.util.Scanner;
public class IsTriangle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num[] = new int[3];
		int max = 0, sum = 0;
		System.out.print("정수 3개를 입력하시오>>");
		for (int i = 0; i<num.length; i++){
			num[i] = s.nextInt();
			if (max < num[i]) max = num[i];
		}
		for (int i = 0; i<num.length; i++){
			if(num[i]!=max) sum += num[i];
		}
		if(max<sum) System.out.println("삼각형이 됩니다.");
		else System.out.println("삼각형이 안됩니다.");
		s.close();
	}

}
