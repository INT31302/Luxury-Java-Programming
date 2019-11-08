package _8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SnowyTown extends JFrame{
	private MyPanel panel = new MyPanel();
	private Thread snowyThread;
	public SnowyTown() {
		super("´« ³»¸®´Â »þ°¥ÀÇ ¸¶À»");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(null);
		snowyThread = new Thread(panel);
		snowyThread.start();
		setSize(350,350);
		setResizable(false);
		setVisible(true);
	}
	class MyPanel extends JPanel implements Runnable{
		private Vector<Point> snowVector = new Vector<>();
		private ImageIcon icon = new ImageIcon("images\\back.jpg");
		private Image img = icon.getImage();
		public MyPanel() {
			for(int i =0; i<50; i++) {
				int x = (int)(Math.random()*350);
				int y = (int)(Math.random()*350);
				System.out.println(x);
				snowVector.add(new Point(x,-y));
			}
		}
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			for(int i =0; i<snowVector.size(); i++) {
				Point p = snowVector.get(i);
				g.setColor(Color.WHITE);
				g.fillOval(p.x, p.y, 10, 10);
			}
		}
		public void changeSnowPosition() {
			for(int i=0; i<snowVector.size(); i++) {
				if(snowVector.get(i).getY()>350) snowVector.get(i).setLocation((int)(Math.random()*350), -(int)(Math.random()*100));
				else snowVector.get(i).setLocation(snowVector.get(i).getX(), snowVector.get(i).getY()+5);
			}
		}
		public void run() {
			while(true) {
				try {
					Thread.sleep(300);
				}catch(InterruptedException e) {return;}
				changeSnowPosition();
				repaint();
			}
		}
	}
	public static void main(String[] args) {
		new SnowyTown();
	}
}
