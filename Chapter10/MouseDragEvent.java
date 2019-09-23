package _2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseDragEvent extends JFrame {
	private Container c = getContentPane();
	public MouseDragEvent() {
		setTitle("드래깅동안 YELLOW 배경색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBackground(Color.GREEN);
		c.addMouseListener(new MyMouseListener());
		c.addMouseMotionListener(new MyMouseListener());
		
		setSize(300,200);
		setVisible(true);
	}
	class MyMouseListener implements MouseListener, MouseMotionListener{
		public void mousePressed(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseDragged(MouseEvent e) {
			c.setBackground(Color.YELLOW);
		}
		public void mouseReleased(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}
	}
	/*class MyMouseListener expends MouseAdapter implements MouseMotionListener{
		public void mouseDragged(MouseEvent e) {
			c.setBackground(Color.YELLOW);
		}
		public void mouseMoved(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			c.setBackground(Color.GREEN);
		}
	}*/
	public static void main(String[] args) {
		new MouseDragEvent();
	}
}
