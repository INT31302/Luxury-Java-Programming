package _4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldBarFrame extends JFrame {
	private Container contentpane;

	public TextFieldBarFrame() {
		super("숫자가 아닌 키가 입력되는 경우 경고창 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentpane = getContentPane();
		createToolBar();
		setSize(400, 350);
		setVisible(true);
	}

	private void createToolBar() {
		JToolBar tb = new JToolBar();
		JTextField tf = new JTextField();
		tb.add(new JLabel("학번:"));
		tb.add(tf);

		tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() < 48 || e.getKeyChar() > 57) {
					JOptionPane.showMessageDialog(null, e.getKeyChar() + "는 숫자 키가 아닙니다.\n숫자를 입력하세요.", "경고",
							JOptionPane.OK_OPTION);
					e.consume();
				}
			}
		});

		contentpane.add(tb, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new TextFieldBarFrame();
	}
}
