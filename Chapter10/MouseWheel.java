package _7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseWheel extends JFrame{
	public MouseWheel() {
		JLabel label = new JLabel("Love Java");
		label.setFont(new Font("Arial",Font.PLAIN, 10));
		setTitle("마이스 휠을 굴려 폰트 크리 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		label.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				int n = e.getWheelRotation();
				Font f = label.getFont();
				int size = f.getSize();
				if(n < 0) {
					if(size>5) label.setFont(new Font("Arial",Font.PLAIN,size-5));
				}else label.setFont(new Font("Arial",Font.PLAIN,size+5));
			}
		});
		c.add(label);
		
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MouseWheel();
	}
}
