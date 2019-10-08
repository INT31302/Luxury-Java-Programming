package _8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ImageGallayFrame extends JFrame {
	private JRadioButton[] rb = {new JRadioButton("left"), new JRadioButton("right")};
	private ButtonGroup group = new ButtonGroup();
	private JLabel labelImage;
	private ImageIcon image;
	private Vector<ImageIcon> images = new Vector<>();
	private File f = new File("images\\8¹ø");
	private File[] subfiles = f.listFiles();
	private int index = 0;
	public ImageGallayFrame() {
		super("Image Gallery Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new MyPanel1(), BorderLayout.NORTH);
		c.add(new MyPanel2(),BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}
	
	class MyPanel1 extends JPanel{
		public MyPanel1() {
			for(int i =0; i<rb.length; i++) {
				group.add(rb[i]);
				add(rb[i]);
			}
			rb[0].setSelected(true);
		}
	}
	
	class MyPanel2 extends JPanel{
		
		public MyPanel2() {
			for(int i=0; i<subfiles.length; i++) {
				image = new ImageIcon(subfiles[i].getPath());
				Image change = image.getImage().getScaledInstance(400, 225, Image.SCALE_SMOOTH);
				image = new ImageIcon(change);
				System.out.println(subfiles[i].getPath());
				images.add(image);
			}
			labelImage = new JLabel(images.get(0));
			add(labelImage);
			labelImage.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if(rb[0].isSelected()) {
						index++;
						if(index >= images.size()) index = 0;
					}
					else if(rb[1].isSelected()) {
						index--;
						if(index<0) index = images.size()-1;
					}
					labelImage.setIcon(images.get(index));
					
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new ImageGallayFrame();
	}
}
