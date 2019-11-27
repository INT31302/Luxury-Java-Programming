package OC13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonsterGameFrame extends JFrame {
	private GamePanel panel = new GamePanel();
	private JLabel avatar, monster;
	
	class MosnterThread extends Thread{
		private JLabel avatar, monster;
		public MosnterThread(JLabel avatar, JLabel monster) {
			this.avatar = avatar;
			this.monster = monster;
		}
		public void get(JLabel avatar) {
			this.avatar = avatar;
		}
		public void run() {
			while(true) {
				try {
					if(avatar.getX()<=monster.getX()) //몬스터가 오른쪽에 있을 때
						monster.setLocation(monster.getX()-5, monster.getY());
					if(avatar.getX()>= monster.getX()) // 몬스터 왼쪽에 있을 때
						monster.setLocation(monster.getX()+5, monster.getY());
					if(avatar.getY()<= monster.getY()) // 몬스터 아래에 있을 때
						monster.setLocation(monster.getX(), monster.getY()-5);
					if(avatar.getY() >= monster.getY()) // 몬스터 위에 있을 때
						monster.setLocation(monster.getX(), monster.getY()+5);
					sleep(200);
				}catch(InterruptedException e) {return;}
			}
		}
	}
	public MonsterGameFrame() {
		super("Open Challenge 13");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350,350);
		setVisible(true);
	}
	
	class GamePanel extends JPanel{
		public GamePanel() {
			setLayout(null);
			avatar = new JLabel("@");
			avatar.setForeground(Color.RED);
			avatar.setSize(15, 15);
			avatar.setLocation(50, 50);
			add(avatar);
			monster = new JLabel("M");
			monster.setSize(15, 15);
			monster.setLocation(150, 50);
			add(monster);
			
			MosnterThread mt = new MosnterThread(avatar, monster);
			mt.start();
			avatar.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					JLabel label = (JLabel)e.getSource();
					if(e.getKeyChar()=='q') {
						System.exit(0);
					}
					int keyCode = e.getKeyCode();
					switch(keyCode) {
					case KeyEvent.VK_UP:
						if(label.getY()>0)
						label.setLocation(label.getX(), label.getY()-10);
						break;
					case KeyEvent.VK_LEFT:
						if(label.getX()>0)
						label.setLocation(label.getX()-10, label.getY());
						break;
					case KeyEvent.VK_RIGHT:
						if(label.getX()<getWidth()-15)
						label.setLocation(label.getX()+10, label.getY());
						break;
					case KeyEvent.VK_DOWN:
						if(label.getY()<getHeight()-20)
						label.setLocation(label.getX(), label.getY()+10);
						break;
					}
					mt.get(avatar);
				}
			});
			avatar.setFocusable(true);
			avatar.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		new MonsterGameFrame();
	}
}
