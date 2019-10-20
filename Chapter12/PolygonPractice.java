package _6_2;
import javax.swing.*;
import java.awt.*;

public class PolygonPractice extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public PolygonPractice() {
		super("그래픽 다각형 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			for(int i =0; i<9; i++) {
				int[] x = {(int)(getWidth()*i*0.04), getWidth()/2, (int)(getWidth()-getWidth()*i*0.04), getWidth()/2};
				int[] y = {getHeight()/2, (int)(getHeight()*i*0.04), getHeight()/2, (int)(getHeight()-getHeight()*i*0.04)};
				g.drawPolygon(x, y, 4);
			}
			
		}
	}
	public static void main(String[] args) {
		new PolygonPractice();
	}
}
