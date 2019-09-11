import java.util.*;
import java.io.*;

public class SearchWord {
	private File f = new File("words.txt");
	private FileInputStream fis = null;
	private Vector<String> v = new Vector<>();
	private Scanner s = new Scanner(System.in);
	
	public SearchWord() {
		try {
			fis = new FileInputStream(f);
			Scanner fs = new Scanner(fis);
			while(fs.hasNext()) {
				v.add(fs.nextLine());
			}
			fs.close();
			fis.close();
			System.out.println("프로젝트 폴더 밑의 " + f.getName()+" 파일을 읽었습니다...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void run() {
		while(true) {
			System.out.print("단어>>");
			String word =  s.next();
			if(word.equals("그만")) {System.out.println("종료합니다..."); s.close(); return;}
			boolean check = false;
			for(int i =0; i<v.size(); i++) {
				if(v.get(i).indexOf(word) == 0) {System.out.println(v.get(i)); check = true;}
			}
			if(!check) System.out.println("발견할 수 없음");
		}
	}
	public static void main(String[] args) {
		SearchWord sw = new SearchWord();
		sw.run();
	}
}
