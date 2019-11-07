package _7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class SnakeGame extends JFrame {
	private MyPanel panel = new MyPanel();
	private String direction = "left";
	private Thread SnakeThread;
	public SnakeGame() {
		super("스네이크 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		
		SnakeThread = new Thread(panel);
		SnakeThread.start();
		setSize(500,500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel implements Runnable{
		private ImageIcon headicon = new ImageIcon("images\\head.jpg");
		private ImageIcon bodyicon = new ImageIcon("images\\body.jpg");
		private ImageIcon icon = new ImageIcon("images\\bg.jpg");
		private JLabel headLabel = new JLabel(headicon);
		private JLabel bodyLabel;
		private Vector <JLabel>bodies = new Vector<>();
		private Image img = icon.getImage();
		public MyPanel() {
			setLayout(null);
			headLabel.setSize(headicon.getIconHeight(), headicon.getIconHeight());
			headLabel.setLocation(230, 30);
			bodies.add(headLabel);
			add(headLabel);
			for(int i =0; i<11; i++) {
			bodyLabel = new JLabel(bodyicon);
			bodyLabel.setLocation(230+i*20,30);
			bodyLabel.setSize(bodyicon.getIconHeight(), bodyicon.getIconHeight());
			bodies.add(bodyLabel);
			add(bodies.get(i+1));
			}
			setFocusable(true);
			requestFocus();
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch(e.getKeyCode()){
					case KeyEvent.VK_UP:
						direction = "up";
						break;
					case KeyEvent.VK_LEFT:
						direction = "left";
						break;
					case KeyEvent.VK_RIGHT:
						direction = "right";
						break;
					case KeyEvent.VK_DOWN:
						direction = "down";
						break;
					}
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
		}
		
		public void run() {
			while(true) {
				int headX = headLabel.getX();
				int headY = headLabel.getY();
				if(direction.equals("up"))headY -= 20;
				else if(direction.equals("left"))headX -= 20;
				else if(direction.equals( "right"))headX += 20;
				else if(direction.equals( "down"))headY += 20;
				headLabel.setLocation(headX, headY);
				for(int i=bodies.size()-1; i>0; i--) {
					bodies.get(i).setLocation(bodies.get(i-1).getLocation());
				}
				try {
					Thread.sleep(200);
				}catch(InterruptedException e) {return;}
			}
		}
	}
	public static void main(String[] args) {
		new SnakeGame();
	}
}
