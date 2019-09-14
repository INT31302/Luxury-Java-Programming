package OC;
import java.util.*;
import java.io.*;  
public class HangMan {
	private File f = null;
	private FileInputStream fis = null;
	private Vector<String> v = new Vector<>();
	private Scanner s = new Scanner(System.in);
	private char[] word;
	private String answer = null;
	private char[] alpha;
	public HangMan() {
		f = new File("words.txt");
		try {
			fis = new FileInputStream(f);
			Scanner fs = new Scanner(fis);
			while(fs.hasNext()) {
				v.add(fs.nextLine());
			}
		fs.close();
		fis.close();
		System.out.println("지금부터 행맨 게임을 시작합니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void set() {
		int ran = (int)(Math.random()*v.size());
		answer = v.get(ran);
		word = answer.toCharArray();
		alpha = new char[word.length];
		int cnt = 0;
		while(cnt<2) {
			ran = (int)(Math.random()*word.length);
			if(word[ran] != '-') {
			alpha[ran] = word[ran];
			word[ran] = '-';
			cnt++;
			}
		}
	}
	private void run() {
		while(true) {
			set();
			if(!game()) {
				System.out.println("5번 실패하였습니다.");
				System.out.println(answer);
			}
			System.out.print("Next(y/n)?");
			while(true) {
				char input = s.next().charAt(0);
				if(input =='y') break;
				else if(input=='n') {
					s.close();
					return;
				}
				else System.out.println("다시 입력해주세요.");
			}
		}
	}
	private boolean game() {
		for(int i = 0; i < 5; i++) {
			boolean check = false;
			System.out.println(word);
			for(int z = 0; z<word.length; z++) {
				if(word[z] == '-') {check = true; break;}
			}
			if(check) {
				System.out.print(">>");
				char input = s.next().charAt(0);
				for(int j = 0; j<word.length; j++) {
					if(alpha[j] == input) word[j] = alpha[j];
				}
			}else return true;
		}
		return false;
	}
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.run();
	}
}
