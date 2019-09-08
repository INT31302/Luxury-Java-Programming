import java.io.*;

public class DeleteTXT {
	public static void main(String[] args) {
		File f = new File("c:\\temp\\");
		File[] subfiles = f.listFiles();
		int cnt = 0;
		for(int i =0; i <subfiles.length; i++) {
			if(subfiles[i].getName().lastIndexOf(".txt") != -1) {
				subfiles[i].delete();
				System.out.println(subfiles[i].getPath() + " 삭제");
				cnt++;
			}
		}
		System.out.println("총 "+ cnt +"개의 .txt 파일을 삭제하였습니다.");
	}
}
