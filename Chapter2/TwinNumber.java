import java.util.Scanner;
public class TwinNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num;
		while (true)
		{
			System.out.print("2자리수 정수 입력(10~99)>>");
			num = s.nextInt();
			if(num<10 || num >99)
			{
				System.out.println("다시 입력해주시기 바랍니다.");
			}
			else break;
		}
		if(num%10 == num /10)
		{
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		}
		else
		{
			System.out.println("No! 10의 자리와 1의 자리가 다릅니다.");
		}
		s.close();
	}

}
