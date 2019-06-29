import java.util.*;

public class HandGame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str[] = {"가위", "바위", "보"};
		String player;
		
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		while(true)
			{int com = -1, plr = -1;
		System.out.print("가위 바위 보!>>");
		try
		{
		player = s.next();
		s.close();
		if(player.equals("그만"))
		{
			System.out.println("게임을 종료합니다.");
			return;
		}
		com = (int)(Math.random()*3);
		for(int i=0; i<str.length; i++)
		{
			if(player.equals(str[i]))
				plr = i;
		}
		System.out.print("사용자 = " + str[plr] + ", 컴퓨터 = "+str[com] + ", ");
		if(plr == com)
		{
			System.out.println("비겼습니다.");
		}
		else
		{
		switch(plr)
		{
			case 0: // 플레이어 가위
				switch(com)
				{
				case 1: // 컴 바위
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				case 2: // 컴 보
					System.out.println("사용자가 이겼습니다.");
					break;
				}
			break;
			case 1: //플레이어 바위
				switch(com)
				{
				case 0: // 컴 가위
					System.out.println("사용자가 이겼습니다.");
					break;
				case 2: // 컴 보
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				}
			break;
			case 2: //플레이어 보
				switch(com)
				{
				case 0: // 컴 가위
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				case 1: // 컴 바위
					System.out.println("사용자가 이겼습니다.");
					break;
				}
				break;
			}
		}
	}
		catch(ArrayIndexOutOfBoundsException e)
		{return;}
	}
	}
}
