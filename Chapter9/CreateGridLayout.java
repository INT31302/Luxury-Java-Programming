package _3;
import javax.swing.*;
import java.awt.*;

public class CreateGridLayout extends JFrame {
	public CreateGridLayout() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		GridLayout grid = new GridLayout(1, 10);
		
		c.setLayout(grid);
		for(int i =0; i<10; i++) {
			JButton b = new JButton(Integer.toString(i));
			c.add(b);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CreateGridLayout();
	}
}
