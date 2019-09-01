import java.io.*;
import java.util.*;
public class PrintPhoneBook {
	private File f = new File("C:\\temp\\phone.txt");
	private FileInputStream fis = null;
	public PrintPhoneBook(){
		System.out.println( f.getPath()+"를 출력합니다.");
	}
	
	private void run() {
		try {
			fis = new FileInputStream(f);
			Scanner fs = new Scanner(fis);
			while(fs.hasNext()) {
				System.out.println(fs.nextLine());
			}
			fs.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		 PrintPhoneBook ppb = new PrintPhoneBook();
		 ppb.run();
	}
}
