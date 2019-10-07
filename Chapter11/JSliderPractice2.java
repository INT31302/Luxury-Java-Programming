package _7;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JSliderPractice2 extends JFrame{
	public JSliderPractice2() {
		super("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JLabel la = new JLabel("I Love Java");
		la.setFont(new Font("Arial", Font.PLAIN, 10));
		la.setHorizontalAlignment(SwingConstants.CENTER);
		JSlider sl = new JSlider(JSlider.HORIZONTAL,1,100,10);
		sl.setPaintLabels(true);
		sl.setPaintTicks(true);
		sl.setPaintTrack(true);
		sl.setMajorTickSpacing(20);
		sl.setMinorTickSpacing(5);
		c.add(sl,BorderLayout.NORTH);
		c.add(la,BorderLayout.CENTER);
		
		sl.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider)e.getSource();
				la.setFont(new Font("Arial", Font.PLAIN, slider.getValue()));
			}
		});
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JSliderPractice2();
	}
}
