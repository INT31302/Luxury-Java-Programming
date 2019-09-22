package _1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEnterEvent extends JFrame {
	private JLabel lb = new JLabel("�����");
	public MouseEnterEvent() {
		setTitle("���콺 �ø��� ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyMouseListener listener = new MyMouseListener();
		lb.addMouseListener(listener);
		c.add(lb);
		
		setSize(300,200);
		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter{
		public void mouseEntered(MouseEvent e) {
			lb.setText("Love Java");
		}
		public void mouseExited(MouseEvent e) {
			lb.setText("�����");
		}
	}
	public static void main(String[] args) {
		new MouseEnterEvent();
	}
}
