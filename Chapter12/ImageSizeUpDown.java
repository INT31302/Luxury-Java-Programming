package _5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageSizeUpDown extends JFrame {
	private MyPanel panel = new MyPanel();
	public ImageSizeUpDown() {
		super("그래픽 이미지 확대 축소 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(350, 350);
		setVisible(true);
		panel.setFocusable(true);
		panel.requestFocus();
	}
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images\\apple.jpg");
		private Image img = icon.getImage();
		private int width, height;
		public MyPanel() {
			width = img.getWidth(this);
			height = img.getHeight(this);
			addKeyListener(new KeyAdapter() {
				
				@Override
				public void keyPressed(KeyEvent e) {
					Component c = (JComponent)e.getSource();
					if(e.getKeyChar() == '+') {
						width =(int)(width*1.1);
						height = (int)(height*1.1);
					}
					else if (e.getKeyChar()=='-') {
						width =(int)(width*0.9);
						height = (int)(height*0.9);
					}
					c.getParent().repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(img, 10, 10, width, height,this);
		}
	}
	public static void main(String[] args) {
		new ImageSizeUpDown();
	}
}
