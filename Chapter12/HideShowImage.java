package _1_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HideShowImage extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public HideShowImage() {
		super("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images\\back.jpg");
		private Image img = icon.getImage();
		private JButton button = new JButton("Hide/Show");
		private boolean showFlag = true;
		
		public MyPanel() {
			setLayout(new FlowLayout());
			
			add(button);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showFlag = !showFlag;
					MyPanel.this.repaint();
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(showFlag)
				g.drawImage(img,0, 0, getWidth(), getHeight(), this);
		}
		
	}
	
	public static void main(String[] args) {
		new HideShowImage();
	}
}