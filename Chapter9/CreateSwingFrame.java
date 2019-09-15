package _1;
import javax.swing.*;
import java.awt.*;

public class CreateSwingFrame extends JFrame {
	public CreateSwingFrame() {
		setTitle("Let\'s study Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setSize(400,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CreateSwingFrame();
	}
}
