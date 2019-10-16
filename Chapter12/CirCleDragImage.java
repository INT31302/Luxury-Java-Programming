package _2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CirCleDragImage extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public CirCleDragImage() {
		super("이미지 위에 원 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images\\back.jpg");
		private Image img = icon.getImage();
		private int x;
		private int y;
		private boolean showFlag = false;
		public MyPanel() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				showFlag = false;
				repaint();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				showFlag = true;
				x = e.getX();
				y = e.getY();
				repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			if(showFlag) {
				g.setColor(Color.GREEN);
				g.fillOval(x, y, 20, 20);
			}
		}
	}
	
	public static void main(String[] args) {
		new CirCleDragImage();
	}
}
