import java.util.*;
public class ReverseChar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String words;
		System.out.println("문자열을 입력하세요. 빈칸이나 있어도 영어 한글 모두 됩니다.");
		words = s.nextLine();
		int length = words.length();
		for(int i = 1; i < length + 1; i++)
		{ 
			System.out.print(words.substring(i));
			System.out.println(words.substring(0,i));
		}
		s.close();
	}
}
