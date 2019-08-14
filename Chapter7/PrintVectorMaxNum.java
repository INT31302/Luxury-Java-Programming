import java.util.*;

public class PrintVectorMaxNum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		int n, max;
		System.out.print("정수 (-1이 입력될 때까지)>> ");
		while(true) {
			n = s.nextInt();
			if(n == -1){
				max = v.get(0);
				for(int i = 0; i<v.size(); i++) {
					if(max < v.get(i)) max = v.get(i);
				}
				System.out.println("가장 큰 수는 " +  max);
				s.close();
				return;
			}
			else v.add(n);
		}
	}
}
