package _11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class RainGame extends JFrame {
	private WordPanel wPanel = new WordPanel();
	private TypePanel tPanel = new TypePanel();
	private Vector<String> words;
	private String word;
	private JLabel result, answer;
	private RainThread rt;
	
	class RainThread extends Thread{
		boolean Game = false;
		synchronized public void waitGame() {
			if(!Game)
			try {this.wait();}
			catch(InterruptedException e) {return;}
		}
		public boolean check(String input) {
			if(input.equals(word)) {
				Game = false;
				input = null;
				return true;
			}
			return false;
		}
		synchronized public void startGame() {
			Game = true;
			this.notify();
			word = words.get((int)(Math.random()*words.size()));
			answer.setText(word);
			answer.setLocation((int)(Math.random()*200), 30);
		}
		public void run() {
			while(true) {
				try {
					sleep(200);
					answer.setLocation(answer.getX(), answer.getY()+5);
					if(answer.getY()>=430) {
						answer.setLocation(answer.getX(), 30);
						result.setText("시간초과실패");
					}
					waitGame();
				}catch(InterruptedException e) {return;}
			}
		}
	}
	
	public RainGame() {
		super("떨어지는 단어 맞추기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(wPanel,BorderLayout.CENTER);
		c.add(tPanel,BorderLayout.SOUTH);
		
		setSize(400, 500);
		setVisible(true);
		
	}
	
	
	class WordPanel extends JPanel{
		private File Words = new File("words.txt");
		
		public WordPanel() {
			try {
				setLayout(null);
				words = new Vector<>();
				Scanner s = new Scanner(Words);
				while(s.hasNext()) {
					words.add(s.nextLine());
				}
				result = new JLabel("게임시작!");
				result.setSize(80, 30);
				result.setLocation(0, 0);
				add(result);
				answer = new JLabel();
				answer.setForeground(Color.MAGENTA);
				answer.setFont(new Font("Tahoma", Font.ITALIC, 20));
				answer.setSize(150, 30);
				add(answer);
			}catch(Exception e) {e.printStackTrace();}
			
		}
	}
	class TypePanel extends JPanel{
		public TypePanel(){
			rt = new RainThread();
			rt.start();
			rt.startGame();
			TextField tf = new TextField(30);
			tf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input = tf.getText();
					if(input.equals("그만")) {
						rt.interrupt();
					}
					tf.setText("");
					if(rt.check(input)) {
						rt.startGame();
						result.setText("성공");
					}
				}
			});
			add(tf);
			setBackground(Color.LIGHT_GRAY);
		}
	}
	public static void main(String[] args) {
		new RainGame();
	}
}
