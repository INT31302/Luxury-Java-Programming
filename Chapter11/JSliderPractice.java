package _5;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JSliderPractice extends JFrame {
	public JSliderPractice() {
		super("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JSlider sl = new JSlider(JSlider.HORIZONTAL, 100, 200, 150);
		sl.setPaintLabels(true);
		sl.setPaintTrack(true);
		sl.setPaintTicks(true);
		sl.setMajorTickSpacing(20);
		
		c.add(sl);
		JLabel la = new JLabel(Integer.toString(sl.getValue()));
		la.setBackground(Color.GREEN);
		la.setOpaque(true);
		c.add(la);
		
		sl.addChangeListener(new ChangeListener() {
		
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider)e.getSource();
				la.setText(Integer.toString(slider.getValue()));
			}
		});
			
		setSize(300,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JSliderPractice();
	}
}
