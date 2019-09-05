import java.io.*;

public class FindLargestFile {
	public static void main(String[] args) {
		File f = new File("c:\\");
		File[] subfiles = f.listFiles();
		String MaxFile = subfiles[0].getPath();
		long MaxSize = subfiles[0].length();
		for(int i =0; i<subfiles.length; i++) {
			if(subfiles[i].length()>MaxSize) {
				MaxFile = subfiles[i].getPath();
				MaxSize = subfiles[i].length();
			}
		}
		System.out.println("가장 큰 파일은 " + MaxFile +" " + MaxSize +"바이트");
	}
}
