public class Clap369Game {
	public static void main(String[] args) {
		
		int num1, num2;
		for(int i =1; i<100; i++)
		{
			if(i<10)
			{
				if(i%3==0)
				{
					System.out.println(i +"박수 짝");
				}
			}
			else
			{
				num1 = i / 10;
				num2 = i % 10;
				if((num1 % 3 ==0 || num2 % 3 ==0)&& num2 !=0 )
				{
					System.out.print(i + "박수 ");
					if(num1 % 3 == 0) System.out.print("짝");
					if(num2 % 3 ==0) System.out.print("짝");
					System.out.println();
				}
			}
			
		}
	}
}
