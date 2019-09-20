package _7;
import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel{
	public NorthPanel() {
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		setLayout(fl);
		setBackground(Color.LIGHT_GRAY);
		add(new JLabel("수식입력"));
		add(new  JTextField("",16));

	}
}

class CenterPanel extends JPanel{
	public CenterPanel() {
		GridLayout grid = new GridLayout(4, 4, 5, 5);
		setLayout(grid);
		setBackground(Color.WHITE);
		JButton[] b = {new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/")};
		for(int i =0; i<10; i++) {
			add(new JButton(Integer.toString(i)));
		}
		add(new JButton("CE"));
		add(new JButton("계산"));
		for(int i =0; i<4; i++) {
			b[i].setBackground(Color.CYAN);
			add(b[i]);
		}
		
	}
}

class SouthPanel extends JPanel{
	public SouthPanel() {
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		
		setLayout(fl);
		setBackground(Color.YELLOW);
		add(new JLabel("계산결과"));
		add(new  JTextField(15));

		
	}
}
public class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CalculatorFrame();
	}
}
