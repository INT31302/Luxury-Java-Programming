import java.util.*;
import java.io.*;

public class CreatePhoneBook {
	public CreatePhoneBook(){
		System.out.println("전화번호 입력 프로그램입니다.");
	}
	private void run() {
		File f = null;
		FileWriter fw = null;
		Scanner s = new Scanner(System.in);
		try {
			f =  new File("C:\\temp\\phone.txt");
			fw = new FileWriter(f);
			while(true){
				System.out.print("이름 전화번호 >> ");
				String text = s.nextLine();
				if(text.equals("그만")) {fw.close();break;}
				fw.write(text+"\r\n");
			}
			System.out.println(f.getPath()+"에 저장하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		s.close();
	}
	public static void main(String[] args) {
		CreatePhoneBook cpb = new CreatePhoneBook();
		cpb.run();
	}
}
