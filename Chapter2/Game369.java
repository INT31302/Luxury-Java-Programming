import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num1, num2=0;
		while(true)
		{
			System.out.print("1~99 사이의 정수를 입력하시오>>");
			num1 = s.nextInt();
			if(num1<1 || num1>99)
				System.out.println("다시 입력하세요.");
			else break;
		}
		if(num1 >10)
		{
			num2 = num1%10;
			num1 = num1/10;
		}
		if((num1%3 == 0 &&num1!=0) || (num2 % 3 ==0 && num2 != 0))
		{
			System.out.print("박수");
	
			if(num1 % 3 == 0 &&num1!=0 )	System.out.print("짝");
		
			if(num2 %3 == 0&&num1!=0 )	System.out.println("짝");
			else System.out.println();
		}
		s.close();
	}
}
