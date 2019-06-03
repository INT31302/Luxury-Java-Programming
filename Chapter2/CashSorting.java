import java.util.Scanner;

public class CashSorting {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num;
		System.out.print("금액을 입력하시오>>");
		num = s.nextInt();
		if(num/50000 > 0)
		{
			System.out.println("오만원권 "+num/50000+"매");
			num %= 50000;
		}
		if(num/10000 > 0)
		{
			System.out.println("만원권 "+num/10000+"매");
			num %= 10000;
		}
		if(num/1000 > 0)
		{
			System.out.println("천원권 "+num/1000+"매");
			num %= 1000;
		}
		if(num/500 > 0)
		{
			System.out.println("오백원권 "+num/500+"매");
			num %= 500;
		}
		if(num/100 > 0)
		{
			System.out.println("백원권 "+num/100+"매");
			num %= 100;
		}
		if(num/50 > 0)
		{
			System.out.println("오십원권 "+num/50+"매");
			num %= 50;
		}
		if(num/10 > 0)
		{
			System.out.println("십원권 "+num/10+"매");
			num %= 20;
		}
		if(num/1 > 0)
		{
			System.out.println("일원권 "+num/1+"매");
		}
		s.close();
	}
