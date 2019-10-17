package _4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageGraphicDrag extends JFrame{
	private MyPanel panel = new MyPanel();
	public ImageGraphicDrag() {
		super("이미지 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(panel);
		setSize(350,350);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images\\apple.jpg");
		private Image img = icon.getImage();
		private MyMouseListener ml = new MyMouseListener();
		public MyPanel() {
			this.addMouseListener(ml);
			this.addMouseMotionListener(ml);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
				g.drawImage(img, 100, 100, icon.getIconWidth(), icon.getIconHeight(), this);

		}
	}
	class MyMouseListener extends MouseAdapter{
		private Point startP = null;
		private Point endP = null;
		public void mousePressed(MouseEvent e) {
			startP = e.getPoint();
		}
		public void mouseReleased(MouseEvent e) {
			endP = e.getPoint();
			Component c = (JComponent)(e.getSource());
			Point p = c.getLocation();
			c.setLocation(p.x+endP.x-startP.x, p.y+endP.y-startP.y);
			c.getParent().repaint();
		}
		
		public void mouseDragged(MouseEvent e) {
			endP = e.getPoint();
			Component c = (JComponent)(e.getSource());
			Point p = c.getLocation();
			c.setLocation(p.x+endP.x-startP.x, p.y+endP.y-startP.y);
			c.getParent().repaint();
		}
	}
	public static void main(String[] args) {
		new ImageGraphicDrag();
	}
}
