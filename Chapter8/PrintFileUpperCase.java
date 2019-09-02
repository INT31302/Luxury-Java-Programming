import java.io.*;
import java.util.*;
public class PrintFileUpperCase {
	private void run() {
		File f = new File("c:\\windows\\system.ini");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			Scanner fs = new Scanner(fis);
			while(fs.hasNext()) {
				String line = fs.nextLine();
				System.out.println(line.toUpperCase());
			}
			fs.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		PrintFileUpperCase pfuc = new PrintFileUpperCase();
		pfuc.run();
	}
}
