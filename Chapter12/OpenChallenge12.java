package OC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OpenChallenge12 extends JFrame {
	private MyPanel panel = new MyPanel();
	private int x = 0, y = 0;
	public OpenChallenge12() {
		super("Open Challenge 12");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(400,400);
		setVisible(true);
		panel.setFocusable(true);
		panel.requestFocus();
	}
	class MyPanel extends JPanel{
		public MyPanel(){
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_UP) {
						if(y>=10) y-= 10;
					}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						if(x>=10) x-= 10;
					}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						if(x<=getWidth()-60) x+=10;
					}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						if(y<=getHeight()-60) y+=10;
					}
					repaint();
				}
			});
		}
		private ImageIcon icon = new ImageIcon("images\\bg.jpg");
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(x, y, 50, 50);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	public static void main(String[] args) {
		new OpenChallenge12();
	}
}
