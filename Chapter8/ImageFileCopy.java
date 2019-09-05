import java.io.*;

public class ImageFileCopy {
	private File a = new File("a.jpg");
	private File b = new File("b.jpg");
	private FileInputStream fis = null;
	private FileOutputStream fos = null;
	public ImageFileCopy() {
		System.out.println(a.getName() + "를 " + b.getName()+"로 복사합니다.");
		System.out.println("10%마다 *를 출력합니다.");
	}
	private void run() {
		try {
			fis = new FileInputStream(a);
			fos = new FileOutputStream(b);
			copy(fis, fos);
			fis.close();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void copy(FileInputStream src, FileOutputStream dest) throws IOException {
		long FileSizePer = a.length() / 10;
		long Process = 0;
		byte[] buf = new byte[1024];
		int buf_cnt = 0;
		while(true) {
			buf_cnt = src.read(buf, 0, buf.length);
			if(buf_cnt == -1) {
				if(Process>0) System.out.println("*");
				return;
			}
			dest.write(buf);
			Process += buf_cnt;
			
			if(Process >= FileSizePer){
				System.out.print("*");
				Process = 0;
			}
		}
	}
	public static void main(String[] args) {
		ImageFileCopy fc = new ImageFileCopy();
		fc.run();
	}
}
