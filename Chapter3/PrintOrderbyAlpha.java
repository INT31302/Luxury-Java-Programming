import java.util.*;

public class PrintOrderbyAlpha {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char n;
		System.out.print("소문자 알파벳 하나를 입력하시오>>");
		try{
			n = s.next().charAt(0);
			if(n>=97 && n<= 122 )
			{
				for(int i=n; i>=97; i--)
				{
					for(int j = 97; j<=i; j++ )
					{
						System.out.print( (char)j );
					}
					System.out.println();
					n--;
				}
			}
		}catch(InputMismatchException e){
			System.out.println(e.getMeesage());
		}
			s.close();
	}
}
