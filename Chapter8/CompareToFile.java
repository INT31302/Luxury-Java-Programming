import java.util.*;
import java.io.*;

public class CompareToFile {
	private File src, dest;
	private FileInputStream Srcfis = null, Destfis = null;
	public CompareToFile() {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
	}
	
	private void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		String name1 = s.nextLine();
		System.out.print("두번째 파일 이름을 입력하세요>>");
		String name2 = s.nextLine();
		try {
			src = new File(name1);
			Srcfis = new FileInputStream(src);
			dest = new File(name2);
			Destfis = new FileInputStream(dest);
			System.out.println(src.getPath()+"와 " + dest.getPath()+"를 비교합니다.");
			if(Compare(Srcfis, Destfis)) System.out.println("파일이 같습니다.");
			else System.out.println("파일이 서로 다릅니다.");
			Srcfis.close();
			Destfis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		s.close();
	}
	private boolean Compare(FileInputStream src, FileInputStream dest) throws IOException {
		int src_cnt = 0, dest_cnt = 0;
		byte[] srcb = new byte[50];
		byte[] destb = new byte[50];
		while(true) {
			src_cnt = src.read(srcb, 0, srcb.length);
			dest_cnt = dest.read(destb, 0, destb.length);
			if(src_cnt != dest_cnt) return false;
			if(src_cnt == -1) break;
			for(int i = 0; i< src_cnt; i++) if(srcb[i] != destb[i]) return false;
			
		}
		return true;
	}
	public static void main(String[] args) {
		CompareToFile c2f = new CompareToFile();
		c2f.run();
	}
}
