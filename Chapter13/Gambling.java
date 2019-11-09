package _9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gambling extends JFrame {
	private MyPanel panel = new MyPanel();
	
	class GamblingThread extends Thread{
		boolean gambling = false;
		private JLabel[] label;
		private JLabel text;
		public GamblingThread(JLabel[] label, JLabel text) {
			this.label = label;
			this.text = text;
		}
		synchronized public void waitForGambling() {
			if(!gambling) {
				try {this.wait();}
				catch(InterruptedException e) {return;}
			}
		}
		synchronized public void startGambling() {
			gambling = true;
			this.notify();
			System.out.println("bb");
		}
		public void run() {
			
			while(true) {
				waitForGambling();
				try {
					for(int i=0; i<label.length; i++) {
						int ran = (int)(Math.random()*5);
						label[i].setText(Integer.toString(ran));
						Thread.sleep(200);
						}
					if(label[0].getText().equals(label[1].getText()) && label[1].getText().equals(label[2].getText())) text.setText("축하합니다!!");
					else	text.setText("아쉽군요");
					gambling = false;
					}
					catch(InterruptedException e) {return;}
				}			
			}
		}
	public Gambling() {
		super("스레드를 가진 겜블링");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,220);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private JLabel[] label = new JLabel[3];
		private JLabel text;
		public MyPanel() {
			setLayout(null);
			for(int i =0; i <  3; i++) {
				label[i] = new JLabel(Integer.toString(0));
				label[i].setOpaque(true);
				label[i].setBackground(Color.MAGENTA);
				label[i].setForeground(Color.YELLOW);
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
				label[i].setSize(60, 30);
				label[i].setLocation(30+80*i, 50);
				label[i].setHorizontalAlignment(SwingConstants.CENTER);
				add(label[i]);
			}
			text = new JLabel("마우스를 클릭할 때 마다 게임합니다.");
			text.setSize(250, 20);
			text.setLocation(30, 120);
			text.setHorizontalAlignment(JLabel.CENTER);
			add(text);
			GamblingThread gt = new GamblingThread(label,text);
			gt.start();
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					gt.startGambling();
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new Gambling();
	}
}
