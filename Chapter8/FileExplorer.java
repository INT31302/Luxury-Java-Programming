package _13;
import java.util.*;
import java.io.*;

public class FileExplorer {
	private File f = null;
	private File[] subfiles = null;
	private Scanner s = new Scanner(System.in);
	
	public FileExplorer(String dir) {
		System.out.println("***** 파일 탐색기입니다. *****");
		f = new File(dir);
		subfiles = f.listFiles();
		showDirectory();
	}
	
	private void showDirectory() {
		System.out.println("\t["+f.getPath() + "]");
		for(int i = 0; i<subfiles.length; i++) {
			if(subfiles[i].isDirectory()) System.out.print("dir");
			else System.out.print("file");
			System.out.printf("\t\t%-10s", subfiles[i].length()+"바이트");
			System.out.println("\t\t"+ subfiles[i].getName());
		}
	}
	
	private boolean Contain(String dir) {
		for(int i = 0; i < subfiles.length; i++) {
			if(subfiles[i].getName().equals(dir)) {
				if(subfiles[i].isDirectory()) return true;
				else{
					System.out.println("폴더가 아닙니다."); return false;
				}
			}
		}
		System.out.println("잘못된 경로입니다,");
		return false;
	}
	private void run() {
		while(true) {
			System.out.print(">>");
			String dir = s.nextLine();
			if(dir.equals("그만")) {s.close(); return;}
			if(dir.equals("..")) {
				if(f.getParent() != null) {
					f = new File(f.getParent());
					subfiles = f.listFiles();
					showDirectory();
				}
				else System.out.println("최상위 경로입니다.");
			}
			else {
				if(Contain(dir)) {
					f = new File(f.getPath()+"\\"+dir);
					subfiles = f.listFiles();
					showDirectory();
				}
			}
		}
	}
	public static void main(String[] args) {
		FileExplorer ex =new FileExplorer("c:\\");
		ex.run();
	}
}
