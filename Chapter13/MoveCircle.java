package _2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MoveRunnable implements Runnable{
	public void run() {
		try {
				Thread.sleep(400);		
		}catch(InterruptedException e){return;}
	}
}

public class MoveCircle extends JFrame {
	private Thread th;
	private MyPanel panel =new MyPanel();
	public MoveCircle() {
		super("원을 0.5초 간격으로 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private int x;
		private int y;
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					repaint();
					MoveRunnable mr = new MoveRunnable();
					th = new Thread(mr);
					th.run();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			x = (int)(Math.random()*getWidth());
			y = (int)(Math.random()*getHeight());
			g.setColor(Color.MAGENTA);
			g.drawOval(x, y, 50, 50);
		}
	}
	public static void main(String[] args) {
		new MoveCircle();
	}
}
