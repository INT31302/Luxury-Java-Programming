package _10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnterDrawOval extends JFrame {
	private MyPanel panel = new MyPanel();
	private int x, y, width, height;
	
	class DrawingThread extends Thread{
		boolean Drawing = false;
		
		synchronized public void waitDrawing() {
			if(!Drawing) 
				try{this.wait();}
				catch(InterruptedException e) {return;}
		}
		synchronized public void startDrawing() {
			Drawing = true;
			this.notify();
		}
		synchronized public void pauseDrawing() {
			Drawing = false;
		}
		public void run() {
			while(true) {
				waitDrawing();
				try {
					x = (int)(Math.random()*300);
					y = (int)(Math.random()*300);
					width = (int)(Math.random()*100);
					height = (int)(Math.random()*100);
					repaint();
					Thread.sleep(500);
				}catch(InterruptedException e) {return;}
			}
		}
	}
	public EnterDrawOval() {
		super("Make Drawing to Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public MyPanel() {
			DrawingThread dt = new DrawingThread();
			dt.start();
			addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
						dt.startDrawing();
						}
				public void mouseExited(MouseEvent e) {
					dt.pauseDrawing();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			g.fillOval(x, y, width, height);
		}
	}
	public static void main(String[] args) {
		new EnterDrawOval();
	}
}
