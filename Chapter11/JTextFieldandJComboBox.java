package _2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JTextFieldandJComboBox extends JFrame {
	public JTextFieldandJComboBox() {
		super("JTextField  and JComboBox Function");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JTextField tf = new JTextField(13);
		JComboBox<String> cb = new JComboBox<>();
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				cb.addItem(t.getText());
				t.setText("");
			}
		});
		c.add(tf);
		c.add(cb);
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JTextFieldandJComboBox();
	}
}
