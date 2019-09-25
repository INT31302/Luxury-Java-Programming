package _4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeftKeyMove extends JFrame {
	private String a = "Love Java";
	public LeftKeyMove() {
		JLabel label  = new JLabel(a);
		setTitle("Left 키로 문자열 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.add(label);
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
				JLabel la = (JLabel)e.getSource();
				a = la.getText().substring(1);
				a += la.getText().substring(0, 1);	
				la.setText(a);
				}
			}
		});
		setSize(300,150);
		setVisible(true);
		
		label.setFocusable(true);
		label.requestFocus();
	}
	
	public static void main(String[] args) {
		new LeftKeyMove();
	}
}
