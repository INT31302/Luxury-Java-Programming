package _5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class KeyPlusMinus extends JFrame {
	public KeyPlusMinus() {
		JLabel label = new JLabel("Love Java");
		label.setFont(new Font("Arial", Font.PLAIN, 10));
		setTitle("+,- 키로 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		c.add(label);
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				JLabel la =(JLabel)e.getSource();
				Font f = la.getFont();
				int size = f.getSize();
				if(e.getKeyChar() == '+') {
					la.setFont(new Font("Arial",Font.PLAIN, size+5));
				}else if(e.getKeyChar()=='-') {
					if(size>5) la.setFont(new Font("Arial",Font.PLAIN, size-5));
				}
			}
		});
		setSize(300,150);
		setVisible(true);
		
		label.setFocusable(true);
		label.requestFocus();
	}
	public static void main(String[] args) {
		new KeyPlusMinus();
	}
}
