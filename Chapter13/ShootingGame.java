package _5;
import javax.swing.*;

import javafx.scene.effect.BlurType;

import java.awt.*;
import java.awt.event.*;

public class ShootingGame extends JFrame {
	private MyPanel panel = new MyPanel();
	private ImageIcon icon;
	private JLabel BulletLabel, rectLabel;
	private int x, y;

	class ChickenThread extends Thread{
		private JLabel label;
		public ChickenThread(JLabel label) {
			this.label = label;
		}
		public void run() {
			while(true) {
				try {
					Thread.sleep(20);
				}catch(InterruptedException e) {
					label.setLocation(0, 0);
					try {
						Thread.sleep(500);
					}catch(InterruptedException ex) {return;}
					
				}
				if(label.getX() <= label.getParent().getWidth()+5) label.setLocation(label.getX()+5, label.getY());
				else label.setLocation(0, 0);
			}
		}
	}

	class rectThread extends Thread{
		private JLabel rectLabel;
		private JLabel BulletLabel;
		private Thread ChickenThread;
		public rectThread(JLabel rectLabel, JLabel BulletLabel, Thread ChickenThread) {
			this.rectLabel = rectLabel;
			this.BulletLabel = BulletLabel;
			this.ChickenThread = ChickenThread;
		}
		public void run() {
			while(true) {
				if(hit()) {
					System.out.println("aa");
					ChickenThread.interrupt();
					rectLabel.setLocation(getWidth()/2-7, getHeight()-88);
					return;
				}else{
					if(rectLabel.getY() < -20) {
						rectLabel.setLocation(getWidth()/2-7, getHeight()-88);
						return;
					}
					else rectLabel.setLocation(rectLabel.getX(), rectLabel.getY()-5);
				}
				try {
					Thread.sleep(20);
				}catch(InterruptedException e) {return;}
				
			}
		}
		public boolean hit() {
			int BulletWidth = BulletLabel.getX()+BulletLabel.getIcon().getIconWidth();
			int BulletHeight = BulletLabel.getY() + BulletLabel.getIcon().getIconHeight();
			if((rectLabel.getX() >= BulletLabel.getX() &&rectLabel.getX() <= BulletWidth) && (rectLabel.getY()>= BulletLabel.getY() &&rectLabel.getY() <= BulletHeight)) return true;
			else return false;
		}
	}
	
	public ShootingGame() {
		super("사격게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(null);
		setSize(350,350);
		setVisible(true);
		setResizable(false);
		ChickenThread ct = new ChickenThread(BulletLabel);
		ct.start();
		
		rectLabel.addKeyListener(new KeyAdapter() {
			rectThread rt = null;
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() =='\n') {
					if(rt == null || !rt.isAlive()) {
						rt = new rectThread(rectLabel, BulletLabel, ct);;
						rt.start();
					}
				}
			}
		});
		rectLabel.setLocation(getWidth()/2-7, getHeight()-88);
		rectLabel.setFocusable(true);
		rectLabel.requestFocus();
	}
	
	class MyPanel extends JPanel{
		public MyPanel() {
			icon  = new ImageIcon("images\\chicken.jpg");
			BulletLabel = new JLabel(icon);
			BulletLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
			BulletLabel.setLocation(0, 0);
			add(BulletLabel);
			rectLabel = new JLabel();
			rectLabel.setSize(10, 10);
			rectLabel.setOpaque(true);
			
			rectLabel.setBackground(Color.RED);
			add(rectLabel);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillRect(getWidth()/2-25, getHeight()-50, 50, 50);
		}
	}
	public static void main(String[] args) {
		new ShootingGame();
	}
}
