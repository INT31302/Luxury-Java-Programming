import java.util.*;
import java.io.*;

public class SearchingList {
	private File f = new File("phone.txt");
	private FileInputStream fis = null;
	private Scanner s = new Scanner(System.in);
	private HashMap<String, String> map = new HashMap<>();
	private StringTokenizer st;
	public SearchingList() {
		try {
			fis = new FileInputStream(f);
			Scanner fs = new Scanner(fis);
			while(fs.hasNext()) {
				st = new StringTokenizer(fs.nextLine(), " ");
				map.put(st.nextToken(), st.nextToken());
			}
			fs.close();
			fis.close();
			System.out.println("총 "+map.size()+"개의 전화번호를 읽었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void run() {
		while(true) {
			System.out.print("이름>> ");
			String name = s.next();
			if(name.equals("그만")) {
				s.close();
				return;
			}
			 if(map.containsKey(name)) System.out.println(map.get(name));
			 else System.out.println("찾는 이름이 없습니다.");
		}
	}
	public static void main(String[] args) {
		SearchingList sl = new SearchingList();
		sl.run();
	}
}
