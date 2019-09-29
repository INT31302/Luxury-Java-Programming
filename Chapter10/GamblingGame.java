package OC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamblingGame extends JFrame {
	public GamblingGame() {
		super("Open Challenge 10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel[] intLabel = new JLabel[3];
		for(int i =0; i< intLabel.length; i++) {
			int ran = (int)(Math.random()*5);
			intLabel[i] = new JLabel(Integer.toString(ran));
			intLabel[i].setSize(60, 30);
			intLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			intLabel[i].setLocation(30+80*i, 50);
			intLabel[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
			intLabel[i].setOpaque(true);
			intLabel[i].setBackground(Color.MAGENTA);
			intLabel[i].setForeground(Color.YELLOW);
			c.add(intLabel[i]);
		}
		JLabel result = new JLabel("시작합니다.");
		result.setSize(200, 20);
		result.setLocation(100, 120);
		
		c.add(result);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '\n') {
					for(int i =0; i<intLabel.length; i++) {
						int ran = (int)(Math.random()*5);
						intLabel[i].setText(Integer.toString(ran));
					}
					if(intLabel[0].getText().equals(intLabel[1].getText()) && intLabel[1].getText().equals(intLabel[2].getText()))
						result.setText("축하합니다,");
					else
						result.setText("아쉽군요");
				}
			}
		});
		
		setSize(300,200);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	
	public static void main(String[] args) {
		new GamblingGame();
	}
}
