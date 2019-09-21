package _8;
import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public NorthPanel() {
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		flow.setVgap(5);
		setLayout(flow);
		add(new JButton("열기"));
		add(new JButton("닫기"));
		add(new JButton("나가기"));
		setBackground(Color.LIGHT_GRAY);
	}
}

class CenterPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public CenterPanel() {
		setLayout(null);
		for(int i =0; i<10; i++) {
			JLabel lb = new JLabel("*");
			lb.setSize(10,10);
			int x = (int)(Math.random()*280);
			int y = (int)(Math.random()*180);
			lb.setLocation(x, y);
			lb.setForeground(Color.RED);
			add(lb);
		}
		setBackground(Color.WHITE);
	}
}

class SouthPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public SouthPanel() {
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
		flow.setVgap(5);
		setLayout(flow);
		add(new JButton("Word Input"));
		add(new TextField(20));
		setBackground(Color.YELLOW);
	}
}
public class MultiplePanels extends JFrame{
	private static final long serialVersionUID = 1L;
	public MultiplePanels() {
		Container c = getContentPane();
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MultiplePanels();
	}
}
