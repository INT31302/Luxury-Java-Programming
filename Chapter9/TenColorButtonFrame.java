package _4;
import javax.swing.*;
import java.awt.*;

public class TenColorButtonFrame extends JFrame {
	public TenColorButtonFrame() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		GridLayout g = new GridLayout(1, 10);
		c.setLayout(g);
		JButton[] b = new JButton[10];
		Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.LIGHT_GRAY, Color.PINK, Color.MAGENTA, Color.WHITE};
		for(int i =0; i<10; i++) {
			b[i] = new JButton(Integer.toString(i));
			b[i].setBackground(colors[i]);
			c.add(b[i]);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TenColorButtonFrame();
	}
}
