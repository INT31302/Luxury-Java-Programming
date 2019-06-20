import java.util.*;
public class MoneyCounter {

	public static void main(String[] args) {
		int [] unit = {50000,10000,1000,500,100,50,10,1};
		Scanner s = new Scanner(System.in);
		int num=0;
		System.out.print("금액을 입력하시오>>");
		try
		{
			num = s.nextInt();
			if(num<0) num *= (-1);
		}
		catch(InputMismatchException e)
		{
			
		}

		for(int i=0; i<unit.length; i++)
		{
			if(num/unit[i] > 0)
			System.out.println(unit[i]+"원 짜리 : " + num/unit[i] + "개");
			num %= unit[i];
		}
		s.close();
	}
}
