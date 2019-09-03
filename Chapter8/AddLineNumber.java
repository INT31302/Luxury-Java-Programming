import java.util.*;
import java.io.*;

public class AddLineNumber {
	private File f = new File("c:\\windows\\system.ini");
	private FileReader fr = null;
	public AddLineNumber() {
		System.out.println(f.getPath()+"  파일을 읽어 출력합니다.");
	}
	private void run() {
		try {
			int line_number = 1;
			fr = new FileReader(f);
			Scanner fs = new Scanner(fr);
			while(fs.hasNext()) {
				System.out.printf("%4s",line_number++);
				System.out.println(": " + fs.nextLine());
			}
			fr.close();
			fs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		AddLineNumber aln = new AddLineNumber();
		aln.run();
	}
}
