import java.util.*;

interface Stack{
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}

class StringStack implements Stack{
	private int length, capacity;
	private String s_arr[];
	public StringStack(int length){
		this.length = length;
		s_arr = new String[length];
		for(int i =0; i<length; i++) s_arr[i] =new String();
	}
	public int length() {
		length = 0;
		for(int i =0; i<s_arr.length; i++)
		{
			if(!s_arr[i].equals("")) length++;
		}
		return length;
	}
	public int capacity() {
		capacity = 0;
		for(int i =0; i<s_arr.length; i++)
		{
			if(s_arr[i].equals("")) capacity++;
		}
		return capacity;
	}
	public String pop() {
		length();
		String result ="";
		for(int i = length-1 ; i>=0; i--) result += s_arr[i]+" ";
		return  result +="\n";
	}
	public boolean push(String val) {
		length(); capacity();
		if(length == s_arr.length)
			return false;
		s_arr[length] = val;
		return true;
	}
}

public class StringStackProgram {
	private Scanner s = new Scanner(System.in);
	private int size;
	private StringStack ss;
	private String word;
	public StringStackProgram(){
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		size = s.nextInt();
		ss = new StringStack(size);
	}
	public void run(){
		System.out.print("문자열 입력 >>");
		word = s.next();
		while(true)
		{
			if(word.equals("그만")) 
			{
				s.close();
				System.out.print("스택에 저장된 모든 문자열 팝 : " + ss.pop()); 
				return;
			}
			if(!ss.push(word)) System.out.println("스택이 꽉 차서 푸시 불가!");
			System.out.print("문자열 입력 >>");
			word = s.next();
		}
	}
	
	public static void main(String[] args) {
		StringStackProgram StackApp = new StringStackProgram();
		StackApp.run();
		
	}
}
