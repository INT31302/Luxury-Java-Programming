package _3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoneyChanger extends JFrame {
	private JTextField[] tf = new JTextField[8];
	private JTextField  input = new JTextField(30); 
	private int[] value = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private String[] text = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
	
	public MoneyChanger() {
		super("Money Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public MyPanel() {
			setBackground(Color.PINK);
			setLayout(null);
			
			JLabel label = new JLabel("금액");
			label.setSize(50, 20);
			label.setLocation(20, 20);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			add(label);
			input.setSize(120, 20);
			input.setLocation(80, 20);
			add(input);
			JButton cal = new JButton("계산");
			cal.setSize(60, 20);
			cal.setLocation(210, 20);
			add(cal);

			for(int i =0; i<tf.length; i++) {
				JLabel la = new JLabel(text[i]);
				la.setSize(50, 20);
				la.setLocation(30, 60+20*i);
				la.setHorizontalAlignment(SwingConstants.RIGHT);
				add(la);
				tf[i] = new JTextField(10);
				tf[i].setSize(90, 20);
				tf[i].setLocation(100, 60+20*i);
				tf[i].setHorizontalAlignment(SwingConstants.CENTER);
				add(tf[i]);
			}
			
			cal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int in = Integer.parseInt(input.getText());
					for(int i =0; i<tf.length; i++) {
						tf[i].setText(Integer.toString(in/value[i]));
						in %= value[i];
					}
					
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new MoneyChanger();
	}
}
