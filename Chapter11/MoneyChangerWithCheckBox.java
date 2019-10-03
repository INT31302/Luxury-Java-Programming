package _4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoneyChangerWithCheckBox extends JFrame {
	private JTextField[] tf = new JTextField[8];
	private JTextField input = new JTextField(30);
	private JCheckBox[] cb = new JCheckBox[7];
	private int[] value = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private String[] text = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
	
	public MoneyChangerWithCheckBox() {
		super("Money Changer With CheckBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(300, 300);
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
				if(i < tf.length -1) {
					cb[i] = new JCheckBox("");
					cb[i].setSize(20, 20);
					cb[i].setLocation(200, 60+20*i);
					cb[i].setOpaque(false);
					add(cb[i]);
				}
			}
			cal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int num = Integer.parseInt(input.getText());
					for(int i = 0; i<cb.length; i++) {
						if(cb[i].isSelected()) {
							tf[i].setText(Integer.toString(num/value[i]));
							num = Integer.parseInt(input.getText())%value[i];
						}else tf[i].setText("0");
					}
					tf[7].setText(Integer.toString(num));
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new MoneyChangerWithCheckBox();
	}
}
