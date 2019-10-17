package _3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageLabelDrag  extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public ImageLabelDrag() {
		super("이미지 레이블 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images\\apple.jpg");
		private JLabel label = new JLabel(icon);
		public MyPanel() {
			label.setSize(getWidth(), getHeight());
			add(label);
			
			MouseAdapter ml = new MyMouseListener();
			label.addMouseListener(ml);
			label.addMouseMotionListener(ml);
		}
		
		class MyMouseListener extends MouseAdapter{
			private Point startP = null;
			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();
			}
			public void mouseDragged(MouseEvent e) {
				Point endP = e.getPoint();
				Component la = (JComponent)e.getSource();
				Point p = la.getLocation();
				la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
				la.getParent().repaint();
			}
		}
	}
	public static void main(String[] args) {
		new ImageLabelDrag();
	}
}
