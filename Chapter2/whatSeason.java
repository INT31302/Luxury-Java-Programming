import java.util.Scanner;
public class whatSeason {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num;
		System.out.println("달을 입력하세요(1~12)>>");
		num = s.nextInt();
		
		// if문 사용
		  if(num > 0 && num<=2 || num==12) 
			System.out.println("겨울");
		else
		{
			if(num<=5)
				System.out.println("봄");
			else if(num<=8)
				System.out.println("여름");
			else if(num<=11)
				System.out.println("가을");
		}
		
    //swtich문 사용
		switch(num)
		{
		case 1:
		case 2:
		case 12:
			System.out.println("겨울");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을");
			break;
		}
		s.close();
	}
}
