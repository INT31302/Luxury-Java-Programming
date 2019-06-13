import java.util.Scanner;

public class HandGame
{
	public static void main(String[] args) {
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		Scanner scanner = new Scanner(System.in);
		
		String player1, player2, player1_name, player2_name;
		
		player1_name="철수";
		player2_name="영희";
		
		System.out.print("철수 >> ");
		player1 = scanner.next();
		
		System.out.print("영희 >> ");
		player2 = scanner.next();
		
		if(player1.equals(player2))
		{
			System.out.println("비겼습니다.");
		}
		else if(player1.equals("가위"))
		{
			switch(player2)
			{
				case "바위":
					System.out.println(player2_name + "가 이겼습니다.");
					break;
				case "보":
					System.out.println(player1_name + "가 이겼습니다.");
					break;
			}
		}
		else if(player1.equals("바위"))
		{
			switch(player2)
			{
			case "가위":
				System.out.println(player1_name + "가 이겼습니다.");
				break;
			case "보":
				System.out.println(player2_name + "가 이겼습니다.");
				break;
			}
		}
		else if(player1.equals("보"))
		{
			switch(player2)
			{
			case "가위":
				System.out.println(player2_name + "가 이겼습니다.");
				break;
			case "바위":
				System.out.println(player1_name + "가 이겼습니다.");
				break;
			}
		}
		scanner.close();
	}
	
}
