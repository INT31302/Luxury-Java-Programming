import java.util.*;
import java.io.*;

public class AppendFile {
	private File src = null, dest = null;
	private FileInputStream srcFs = null, destFs = null;
	private FileWriter result = null;
	private Scanner s = new Scanner(System.in);
	public AppendFile() {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
	}
	private void run() {
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		String name1 = s.nextLine();
		System.out.print("두번째 파일 이름을 입력하세요>>");
		String name2 = s.nextLine();
		try {
			result = new FileWriter(new File("appended.txt"));
			src = new File(name1);
			srcFs = new FileInputStream(src);
			Append(srcFs, result);
			dest = new File(name2);
			destFs = new FileInputStream(dest);
			Append(destFs, result);
			srcFs.close();
			destFs.close();
			result.close();
			System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		s.close();
	}
	
	private void Append(FileInputStream src, FileWriter result) throws IOException{
		Scanner fs = new Scanner(src);
		while(fs.hasNext()) {
			result.write(fs.nextLine()+"\r\n");
		}
		fs.close();
	}
	public static void main(String[] args) {
		AppendFile af = new AppendFile();
		af.run();
	}
}
