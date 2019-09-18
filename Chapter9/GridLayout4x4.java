package _5;
import javax.swing.*;
import java.awt.*;

public class GridLayout4x4 extends JFrame {
	public GridLayout4x4() {
		setTitle("4x4 Color Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		GridLayout grid = new GridLayout(4, 4);
		c.setLayout(grid);
		JLabel[] lb = new JLabel[16];
		Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
				Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
				Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY,
				Color.BLACK, Color.ORANGE, Color.BLUE,Color.MAGENTA};
		for(int i =0; i<lb.length; i++) {
			lb[i] = new JLabel(Integer.toString(i));
			lb[i].setOpaque(true);
			lb[i].setBackground(color[i]);
			c.add(lb[i]);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayout4x4();
	}
}
