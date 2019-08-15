import java.util.*;

public class ArrayListAvg {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Character> ca = new ArrayList<>();
		char c;
		double sum = 0, avg;
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		for(int i =0; i<6; i++){
			c = s.next().charAt(0);
			ca.add(c);
		}
		
		for(int i = 0; i<ca.size(); i++){
			switch(ca.get(i)) {
			case 'A':
				sum += 4.0;
				break;
			case 'B':
				sum += 3.0;
				break;
			case 'C':
				sum += 2.0;
				break;
			case 'D':
				sum += 1.0;
				break;
			}
		}
		avg = sum/ca.size();
		System.out.println(avg);
		s.close();
	}
}
