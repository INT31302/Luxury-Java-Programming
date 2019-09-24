package _3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeftKeyReverse extends JFrame {
	JLabel la = new JLabel("Love Java");
	public LeftKeyReverse() {
		setTitle("Left키로 문자열 교체");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		la.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					JLabel label = (JLabel)e.getSource();
					StringBuffer sb = new StringBuffer(label.getText());
					label.setText(sb.reverse().toString());
					
				}
			}
		});
		c.add(la);
		setSize(300,150);
		setVisible(true);
		
		la.setFocusable(true);
		la.requestFocus();
	}
	public static void main(String[] args) {
		new LeftKeyReverse();
	}

}
