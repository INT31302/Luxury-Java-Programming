package _1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxPractice extends JFrame {
	public CheckBoxPractice() {
		super("CheckBox Practive Function");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox[] cb = {new JCheckBox("버튼 비활성화"), new JCheckBox("버튼 감추기")};
		JButton b = new JButton("test button");
		cb[0].addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox chck = (JCheckBox)e.getSource();
				if(chck.isSelected()) b.setEnabled(false);
				else b.setEnabled(true);
			}
		});
		
		cb[1].addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox chck = (JCheckBox)e.getSource();
				if(chck.isSelected())b.setVisible(false);
				else b.setVisible(true);
			}
		});
		c.add(cb[0]);
		c.add(cb[1]);
		c.add(b);
		
		setSize(300,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxPractice();
	}
}
