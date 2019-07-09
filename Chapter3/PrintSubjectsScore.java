import java.util.*;

public class PrintSubjectsScore {
	public static void main(String[] args) {
		String course[] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
		int score [] = {95, 88, 76, 62, 55};
		Scanner s = new Scanner(System.in);
		String input_name;
		int cnt = -1;
		while(true){
			System.out.print("과목 이름>>");
			input_name = s.next();
			if(input_name.equals("그만")) break;
			for(int i =0; i<course.length; i++){
				if(input_name.equals(course[i])){
					cnt = i;
					break;
				}
			}
			if(cnt != -1){
				System.out.println(course[cnt]+"의 점수는 " + score[cnt]);
				cnt = -1;
			}
			else
				System.out.println("없는 과목입니다.");
		}
		s.close();
	}
}
