package _3;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class DigitalClock extends JFrame {
	private Thread th;
	
	class	TimerRunnable implements Runnable{
		private JLabel clock;
		public TimerRunnable(JLabel clock) {
			this.clock = clock;
		}
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {return;}
			}
		}
	}
	public String setClock() {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		return hour+":"+minute+":"+sec;
	}
	
	public DigitalClock(){
		super("디지탈 시계 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JLabel clock = new JLabel(setClock());
		clock.setHorizontalAlignment(JLabel.CENTER);
		clock.setFont(new Font("Gothic",Font.ITALIC, 80));
		TimerRunnable timer = new TimerRunnable(clock);
		th = new Thread(timer);
		th.start();
		c.add(clock,BorderLayout.CENTER);
		setSize(400,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DigitalClock();
	}
}
