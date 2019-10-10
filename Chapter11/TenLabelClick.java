package _10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TenLabelClick extends JFrame {
	private JLabel[] label = new JLabel[10];
	private int count = 0;
	public TenLabelClick() {
		super("Ten 레이블 클릭");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		for(int i = 0; i<label.length; i++) {
			label[i] = new JLabel(Integer.toString(i));
			label[i].setForeground(Color.MAGENTA);
			label[i].setHorizontalAlignment(SwingConstants.CENTER);
			label[i].setFont(new Font("Arial", Font.PLAIN, 20));
			label[i].setSize(30, 30);
			label[i].addMouseListener(new MyMouseListener());
			c.add(label[i]);
		};
		Setting(label);
		setSize(350,350);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			JLabel la = (JLabel)e.getSource();
			if(Integer.parseInt(la.getText()) == count) {
				la.setVisible(false); count++;
			}
			if(count == 10) {Setting(label); count = 0;}
		}
	}
	public void Setting(JLabel[] label) {
		for(int i = 0; i<label.length; i++) {
			int x = (int)(Math.random()*280);
			int y = (int)(Math.random()*280);
			label[i].setLocation(x, y);
			label[i].setVisible(true);
		}
	}
	public static void main(String[] args) {
		new TenLabelClick();
	}
}
