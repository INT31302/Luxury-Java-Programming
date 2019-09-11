import java.util.*;
import java.io.*;

public class SearchWord2 {
	private File f = null;
	private FileInputStream fis = null;
	private Scanner s = new Scanner(System.in);
	private Vector<String> v = new Vector<>();
	public SearchWord2() {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력>> ");
		f = new File(s.nextLine());
		try {
			fis = new FileInputStream(f);
			Scanner fs = new Scanner(fis);
			while(fs.hasNext()) v.add(fs.nextLine());
			fs.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void run() {
		while(true) {
			System.out.print("검색할 단어나 문장>> ");
			String word = s.nextLine();
			if(word.equals("그만")){ System.out.println("프로그램을 종료합니다."); s.close(); return;}
			for(int i = 0; i<v.size(); i++) {
				if(v.get(i).indexOf(word) >= 0) System.out.println(v.get(i));
			}
		}
	}
	public static void main(String[] args) {
		SearchWord2 sw = new SearchWord2();
		sw.run();
	}
}
