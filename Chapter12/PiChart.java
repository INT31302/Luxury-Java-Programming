package _11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PiChart extends JFrame {
	private JLabel[] label = new JLabel[4];
	private String[] text = {"apple","berry","strawberry","prune"};
	private int result = 0;
	private int[] value = {0,0,0,0};
	private MyPanel1 panel1 = new MyPanel1();
	private MyPanel2 panel2 = new MyPanel2();
	public PiChart() {
		super("파이 차트 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel1,BorderLayout.NORTH);
		c.add(panel2,BorderLayout.CENTER);
		
		setSize(550,400);
		setVisible(true);
		new MyPanel1().setFocusable(true);
		new MyPanel1().requestFocus();
	}

	class MyPanel1 extends JPanel{
		public MyPanel1() {
			setBackground(Color.LIGHT_GRAY);
			JTextField[] tf = new JTextField[4];
			for(int i =0; i<tf.length; i++) {
				label[i] = new JLabel(text[i]);
				add(label[i]);
				tf[i] = new JTextField(6);
				add(tf[i]);
				tf[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						result = 0;
						for(int i =0; i<value.length; i++) {
							try {
								
								value[i] = Integer.parseInt(tf[i].getText());
							}
							catch(Exception ex) {
								value[i] = 0;
							}
							result += value[i];
						}
						for(int i =0; i<value.length; i++) {
							value[i] = (int)(Math.round((double)value[i] / result * 100));
						}
						panel2.repaint();
					}
				});
			}
		}
	}
	
	class MyPanel2 extends JPanel{
		private Color[] colors = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE};
		private int previousPer = 0;
		private int currentPer = 0;
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i = 0; i<4; i++) {
				g.setColor(colors[i]);
				g.drawString(text[i]+" "+value[i]+" %     ",20+100*i,10);
				currentPer = (int)Math.round((0.01*value[i]*360));
				g.fillArc(getWidth()/2-100, getHeight()/2-100, 200, 200, previousPer, currentPer);
				previousPer += currentPer;
			}
		}
	}
	public static void main(String[] args) {
		new PiChart();
	}
}
