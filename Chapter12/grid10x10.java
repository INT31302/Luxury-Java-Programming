package _6_1;
import javax.swing.*;
import java.awt.*;

public class grid10x10 extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public grid10x10() {
		super("격자 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i =1; i<10; i++) {
				g.drawLine((int)(getWidth()*(i*0.1)), 0, (int)(getWidth()*(i*0.1)), getHeight());
				g.drawLine(0, (int)(getHeight()*(i*0.1)), getWidth(), (int)(getHeight()*(i*0.1)));
			}
		}
	}
	public static void main(String[] args) {
		new grid10x10();
	}
}
