package _9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class HandGame extends JFrame {
	private File f = new File("images\\9번");
	private File[] subfiles = f.listFiles();
	private ImageIcon image;
	private Vector<ImageIcon> v = new Vector<>();
	private JButton[] b = new JButton[3];
	JLabel me_label;
	JLabel com_label;
	JLabel result;
	public HandGame() {
		super("가위 바위 보 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new MyPanel1(),BorderLayout.NORTH);
		c.add(new MyPanel2(),BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}
	class MyPanel1 extends JPanel{
		public MyPanel1() {
			setBackground(Color.LIGHT_GRAY);
			for(int i =0; i<b.length; i++) {
				image = new ImageIcon(subfiles[i].getPath());
				v.add(image);
				b[i] = new JButton(v.get(i));
				b[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					JButton bu = (JButton)e.getSource();
					me_label.setIcon(bu.getIcon());
					int ran = (int)(Math.random()*v.size());
					com_label.setIcon(v.get(ran));
					
					if(bu.getIcon() == v.get(0) && ran == 2 || bu.getIcon() == v.get(1) && ran == 0 ||
							bu.getIcon() == v.get(2) && ran == 1) result.setText("Me !!!");
					else if(bu.getIcon() == v.get(0) && ran == 1 || bu.getIcon() == v.get(1) && ran == 2 ||
							bu.getIcon() == v.get(2) && ran == 0) result.setText("Computer !!!");
					else result.setText("Same !!!");
					}
				});
				add(b[i]);
			}
		}
	}
	class MyPanel2 extends JPanel{
		public MyPanel2() {
			setBackground(Color.YELLOW);
			me_label = new JLabel("me");
			com_label = new JLabel("com");
			result = new JLabel("Start!");
			result.setForeground(Color.RED);
			add(me_label);
			add(com_label);
			add(result);
		}
		
	}
	public static void main(String[] args) {
		new HandGame();
	}
}
