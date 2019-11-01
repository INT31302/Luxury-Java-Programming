package _4_1;
import javax.swing.*;
import java.awt.*;
public class VibrationFrame extends JFrame {
	
	class VibrationRunnable implements Runnable{
		private int x=100, y=100;
		private int n = 0;
		public void run() {
			while(true) {
				try {
					Thread.sleep(10);
				}catch(InterruptedException e) {return;}
				if(n==0)setLocation(x, y+=10);
				if(n==1)setLocation(x-=10,y);
				if(n==2)setLocation(x, y-=10);
				if(n==3)setLocation(x+=10, y);
				if(n==3) n=0;
				else n++;
				}
			}
		}
	private Thread th;
	public VibrationFrame() {
		super("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(300,300);
		setVisible(true);
		VibrationRunnable vr = new VibrationRunnable();
		th  = new Thread(vr);
		th.run();
	}
	
	public static void main(String[] args) {
		new VibrationFrame();
	}
}
