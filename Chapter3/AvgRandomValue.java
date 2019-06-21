import java.util.*;

public class AvgRandomValue {
	public static void main(String[] args) {
		int n[] = new int[10];
		double sum = 0;
		for(int i = 0; i<n.length; i++)
		{
			n[i] = (int)(Math.random()*10+1);
			sum += n[i];
		}
		
		System.out.print("랜덤한 정수들 : ");
		for(int a : n)
		{
			System.out.print(a + " ");
		}
		System.out.println("\n평균은 " + sum/n.length);
	}
}
