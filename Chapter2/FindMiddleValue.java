import java.util.Scanner;
public class FindMiddleValue {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num[] = new int[3];
		int max, min, middle = 0;
		System.out.print("정수 3개 입력>>");
		try{
			for (int i = 0; i<num.length; i++)
			{
				num[i] = s.nextInt();
			}
			
			max = num[0];
			min = num[0];
			for (int i = 0; i<num.length; i++)
			{
				if(max<num[i]) max = num[i];
				if(min>num[i]) min = num[i];
			}
			
			for (int i = 0; i<num.length; i++)
			{
				if(max != num[i] && min != num[i]) middle = num[i];
			}
			System.out.println(middle);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		s.close();
	}

}
