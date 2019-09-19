package _6;
import javax.swing.*;
import java.awt.*;

public class RandomLabel extends JFrame {
	public RandomLabel() {
		setTitle("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel[] lb = new JLabel[20];
		for(int i = 0; i<lb.length; i++) {
			lb[i] = new JLabel(Integer.toString(i));
			lb[i].setOpaque(true);
			lb[i].setBackground(Color.BLUE);
			int x = (int)(Math.random()*200)+50;
			int y = (int)(Math.random()*200)+50;
			lb[i].setLocation(x, y);
			lb[i].setSize(10, 10);
			c.add(lb[i]);
		}
		setSize(350,350);
		setVisible(true);
	}
	public static void main(String[] args) {
		new RandomLabel();
	}
}
