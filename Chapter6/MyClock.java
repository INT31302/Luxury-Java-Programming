import java.util.Calendar;

public class MyClock {
	public static void main(String[] args) {
		Calendar  now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		System.out.println("현재 시간은 " +hour + "시 " + minute+"분 입니다,");
		if(hour>=22 || hour<4) System.out.println("Good Night");
		else if(hour>=18)System.out.println("Good Evening");
		else if(hour>=12)System.out.println("Good Afternoon");
		else System.out.println("Good Morning");
	}

}
