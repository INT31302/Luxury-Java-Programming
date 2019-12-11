package _3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExitToolBarFrame extends JFrame {
	private Container contentPane;

	public ExitToolBarFrame() {
		super("종료 툴바 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(300, 300);
		setVisible(true);
	}

	private void createToolBar() {
		JToolBar tb = new JToolBar("종료 툴바");
		JButton button = new JButton("종료");
		button.addActionListener(new ExitActionListener());
		tb.add(button);

		add(tb, BorderLayout.NORTH);
	}

	class ExitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION)
				System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ExitToolBarFrame();
	}
}
