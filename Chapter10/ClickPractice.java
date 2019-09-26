package _6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickPractice extends JFrame {
	public ClickPractice() {
		JLabel label = new JLabel("c");
		setTitle("클릭 연습 용 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		label.setLocation(100, 100);
		label.setSize(20,20);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int x = (int)(Math.random()*250);
				int y = (int)(Math.random()*250);
				label.setLocation(x, y);
			}
		});
		c.add(label);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ClickPractice();
	}
}
