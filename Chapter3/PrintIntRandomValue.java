import java.util.*;

public class PrintIntRandomValue {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input_num = 0;
		int temp;
		int cnt=0;
		System.out.print("정수 몇개?");
		try
		{
			input_num = s.nextInt();
			if(input_num<0) input_num*=(-1);
		}
		catch(InputMismatchException e)
		{
			
		}
		int iArray[] = new int[input_num];
		
		for(int i = 0; i < input_num; i++)
		{
			temp = (int)(Math.random()*100+1);
			for(int j = 0; j<i; j++)
			{
				if(temp == iArray[j]) cnt++;
			}
			if (cnt==0) iArray[i] =temp;
			else
			{
				cnt = 0;
				i--;
			}
		}
		
		for(int i = 1; i <= iArray.length; i++)
		{
			System.out.print(iArray[i-1] + " ");
			if(i % 10 == 0) System.out.println(); 
		}
		s.close();
	}
}
