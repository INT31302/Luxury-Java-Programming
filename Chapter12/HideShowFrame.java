package _1_1;
import javax.swing.*;
import java.awt.*;

public class HideShowFrame extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public HideShowFrame() {
		super("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images\\back.jpg");
		private Image img = icon.getImage();
		public MyPanel() {
			setLayout(new FlowLayout());
			add(new JButton("Hide/Show"));
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(img,0, 0, getWidth(), getHeight(), this);
		}
	}
	
	public static void main(String[] args) {
		new HideShowFrame();
	}
}
