package OC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageGallary extends JFrame{
	private ImageIcon[] images = {new ImageIcon("images\\OC\\image0.jpg"), new ImageIcon("images\\OC\\image1.jpg"),
			new ImageIcon("images\\OC\\image2.jpg"), new ImageIcon("images\\OC\\image3.jpg")};
	private JButton[] button = {new JButton("", new ImageIcon("images\\OC\\left.png")), new JButton("",new ImageIcon("images\\OC\\right.png"))};
	private JLabel imageLabel;
	private int index = 0;
	public ImageGallary() {
		super("Open Challenge 11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		imageLabel= new JLabel(images[index]);
		c.add(imageLabel,BorderLayout.CENTER);
		c.add(new MenuPanel(),BorderLayout.SOUTH);
		
		setSize(305,405);
		setVisible(true);
	}
	
	
	class MenuPanel extends JPanel{
		public MenuPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			for(int i =0; i<button.length;i++) {
				add(button[i]);
				button[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						if(b.getIcon() == button[0].getIcon()) {
							index--;
							if(index < 0) index = images.length - 1;
						}
						else if(b.getIcon() == button[1].getIcon()) {
							index++;
							if(index > images.length -1) index = 0;
						}
						imageLabel.setIcon(images[index]);
					}
				});
			}
		}
	}
	public static void main(String[] args) {
		new ImageGallary();
	}
}
