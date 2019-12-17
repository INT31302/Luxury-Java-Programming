package OC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CoffeeMachine extends JFrame {
	private WelcomePanel welP = new WelcomePanel();
	private MainPanel mainP = new MainPanel();
	private ButtonPanel btnP = new ButtonPanel();
	private int[] currentSize = { 10, 10, 10, 10, 10 };
	private ImageIcon icon;
	private JLabel imgLabel;

	public CoffeeMachine() {
		super("Open Challenge 14");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.add(welP, BorderLayout.NORTH);
		c.add(mainP, BorderLayout.CENTER);
		c.add(btnP, BorderLayout.SOUTH);
		setSize(500, 450);
		setResizable(false);
		setVisible(true);
	}

	class WelcomePanel extends JPanel {
		private JLabel welcome = new JLabel("Welcome, Hot Coffee!");

		public WelcomePanel() {
			setBackground(Color.MAGENTA);
			welcome.setHorizontalAlignment(JLabel.CENTER);
			add(welcome);
		}
	}

	class MainPanel extends JPanel {
		private final int maxSize = 10;
		private String[] text = { "Cup", "Coffee", "Water", "Sugar", "Cream" };
		private JLabel[] label = new JLabel[text.length];

		public MainPanel() {
			setLayout(null);
			icon = new ImageIcon("images\\coffee.jpg");
			imgLabel = new JLabel(icon);
			imgLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
			imgLabel.setLocation(180, 230);
			imgLabel.setVisible(false);
			for (int i = 0; i < text.length; i++) {
				label[i] = new JLabel(text[i]);
				label[i].setLocation(30 + i * 80, 120);
				label[i].setSize(40, 20);
				add(label[i]);
			}
			add(imgLabel);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < text.length; i++) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(30 + i * 80, 10, 40, 100);
				g.setColor(Color.GRAY);
				g.drawRect(29 + i * 80, 9, 41, 101);
				g.setColor(getBackground());
				g.fillRect(30 + i * 80, 10, 40, (maxSize - currentSize[i]) * 10);
			}
		}
	}

	public void getCoffee(String text, int index) {
		for (int i = 0; i < index; i++) {
			if (currentSize[i] == 0) {
				imgLabel.setVisible(false);
				JOptionPane.showMessageDialog(null, "부족한 것이 있습니다. 채워주세요,", "커피 자판기 경고",
						JOptionPane.INFORMATION_MESSAGE);

				return;
			}
		}
		for (int i = 0; i < index; i++)
			currentSize[i]--;
		imgLabel.setVisible(true);
		repaint();
		JOptionPane.showMessageDialog(null, "뜨거워요, 즐거운 하루~~", "커피나왔습니다.", JOptionPane.INFORMATION_MESSAGE);
	}

	class ButtonPanel extends JPanel {
		private JButton[] btns = new JButton[4];
		private String[] text = { "Black Coffee", "Sugar Coffee", "Dabang Coffee", "Reset" };

		public ButtonPanel() {
			for (int i = 0; i < btns.length; i++) {
				btns[i] = new JButton(text[i]);
				btns[i].addActionListener(new MyButtonListener());
				add(btns[i]);
			}
		}
	}

	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "Black Coffee":
				getCoffee(cmd, 3);
				break;
			case "Sugar Coffee":
				getCoffee(cmd, 4);
				break;
			case "Dabang Coffee":
				getCoffee(cmd, 5);
				break;
			case "Reset":
				for (int i = 0; i < currentSize.length; i++) {
					currentSize[i] = 10;
					imgLabel.setVisible(false);
					repaint();
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		new CoffeeMachine();
	}
}
