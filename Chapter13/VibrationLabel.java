package _4_2;
import javax.swing.*;
import java.awt.*;

class VibrationRunnable implements Runnable{
	private JLabel label;
	private int n =0;
	private int x = 100, y = 100;
	public VibrationRunnable(JLabel label) {
		this.label = label;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {return;}
			if(n==0)label.setLocation(x, y+=10);
			if(n==1)label.setLocation(x-=10,y);
			if(n==2)label.setLocation(x, y-=10);
			if(n==3)label.setLocation(x+=10, y);
			if(n==3) n=0;
			else n++;
		}
	}
}
public class VibrationLabel extends JFrame {
	private Thread th;
	public VibrationLabel() {
		super("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel label = new JLabel("진동 레이블");
		label.setFont(new Font("Gothic", Font.PLAIN, 30));
		label.setSize(200,100);
		label.setLocation(100, 100);
		add(label);
		setSize(300,300);
		setVisible(true);
		VibrationRunnable vr = new VibrationRunnable(label);
		th  = new Thread(vr);
		th.run();
	}
	public static void main(String[] args) {
		new VibrationLabel();
	}
}
