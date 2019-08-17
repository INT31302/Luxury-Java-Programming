import java.util.*;

public class AvgPrecipitation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n, sum;
		Vector<Integer> v = new Vector<>();
		while(true) {
			sum = 0;
			System.out.print("강수량 입력 (0 입력시 종료)>> ");
			n = s.nextInt();
			if(n == 0) {s.close(); return;}
			v.add(n);
			Iterator<Integer> it = v.iterator();
			while(it.hasNext()) {
				n = it.next();
				System.out.print(n +" ");
				sum += n;
			}
			System.out.println("\n현재 평균 " + sum/v.size());
		}
	}
}
