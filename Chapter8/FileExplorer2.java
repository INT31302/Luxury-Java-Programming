package _14;
import java.util.*;
import java.io.*;

public class FileExplorer2 {
	private File f = null;
	private File[] subfiles = null;
	private Scanner s = new Scanner(System.in);
	
	public FileExplorer2(String dir) {
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
	private void rename(String src, String dest) {
		File fsrc = null;
		for(int i = 0; i<subfiles.length; i++) {
			if(subfiles[i].getName().equals(src)) {
				fsrc = new File(subfiles[i].getPath());
				break;
			}
		}
		if (fsrc !=null) {
			fsrc.renameTo(new File(f.getPath()+"\\"+dest));
			System.out.println(src+"를 " +dest+" 이름 변경하였습니다.");
			subfiles = f.listFiles();
			showDirectory();
		}
		else System.out.println(src+" 파일이 존재하지 않습니다.");
	}
	private void mkdir(String name) {
		for(int i =0; i<subfiles.length; i++) {
			if(subfiles[i].getName().equals("name")) {
				System.out.println("이미 존재하는 파일명입니다.");
				return;
			}
		}
		File newfile = new File(f.getPath()+"\\"+name);
		if(newfile.mkdir()){
			System.out.println(name +" 디렉토리를 생성하였습니다.");
			subfiles = f.listFiles();
			showDirectory();
		}
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
				StringTokenizer st = new  StringTokenizer(dir, " ");
				String command = st.nextToken();
				if(command.equals("rename")) {
					try {
						rename(st.nextToken(),st.nextToken());
					}catch(NoSuchElementException e) {
						System.out.println("두 개의 파일명이 주어지지 않았습니다.!");
					}
					
				}
				else if(command.equals("mkdir")){
					mkdir(st.nextToken());
				}
				else{
					if(Contain(dir)) {
						f = new File(f.getPath()+"\\"+dir);
						subfiles = f.listFiles();
						showDirectory();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		FileExplorer2 ex =new FileExplorer2("c:\\");
		ex.run();
	}
}
