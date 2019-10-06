package _6;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaPractice extends JFrame {
	private JTextArea ta = new JTextArea(5,20);
	private JSlider sl = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
	public TextAreaPractice() {
		super("TextArea Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		sl.setPaintLabels(true);
		sl.setPaintTicks(true);
		sl.setPaintTrack(true);
		sl.setMajorTickSpacing(20);
		sl.setMinorTickSpacing(5);
		sl.setLocation(10, 100);
		sl.setSize(370, 50);
		ta.setSize(380, 90);
		c.add(ta);
		c.add(sl);
		
		ta.addKeyListener(new MyKeyListener());
		sl.addChangeListener(new MySliderChanger());
		setSize(400,200);
		setVisible(true);
	}
	class MyKeyListener extends KeyAdapter{
		@Override
		public void keyTyped(KeyEvent e) {
			if(ta.getText().length()>99) {
				e.consume();
			}
			else sl.setValue(ta.getText().length());
		}
	}
	class MySliderChanger implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			JSlider slider = (JSlider)e.getSource();
			if(ta.getText().length()>slider.getValue()) {
				ta.setText(ta.getText().substring(0, ta.getText().length()-1));
			}
			if(ta.getText().length()< slider.getValue())
				slider.setValue(ta.getText().length());
		}
	}
	public static void main(String[] args) {
		new TextAreaPractice();
	}
}
