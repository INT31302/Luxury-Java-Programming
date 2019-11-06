package _6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BubbleGame extends JFrame {
	private MyPanel panel = new MyPanel();
	private JLabel balloons;

	class BubbleThread extends Thread{
		private JLabel balloons;
		public BubbleThread(JLabel balloons) {this.balloons = balloons;} // 받아온 ballons 레이블을 클래스 내 ballons으로 설정
		public void run() {
			while(true) {
				if(balloons.getY()>-40) { // ballons 레이블의 Y값이 -40을 초과할 경우
					balloons.setLocation(balloons.getX(), balloons.getY()-5); // ballons의 y값을 5씩 감소시킨다.
				}
				else { remove(balloons); repaint(); return;} // ballons 레이블의 값이 Y값이 -40 이하일 경우 ballons 레이블을 삭제시키고 다시그리기 실행하고 스레드 종료
				try {
					sleep(20); // 0.02초(20ms)마다 실행
				}catch(InterruptedException e) {return;} //Interrupt 명령시 스레드 강제 종료
			}
			
		}
	}
	public BubbleGame() {
		super("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(350,350);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images\\balloons.png"); //icon 이미지 설정
		private int cnt = 0;
		private JLabel balloons;
		private Vector<JLabel> v = new Vector<>(); //레이블를 넣어 줄 Vector 생성
		public MyPanel() {
			setLayout(null);
			addMouseListener(new MouseAdapter() {
				BubbleThread bt = null; // bt 스레드 null로 설정
				public void mousePressed(MouseEvent e) { // 마우스 클릭 했을 경우
					balloons = new JLabel(icon); // ballons 이미지 레이블 생성
					balloons.setSize(50, 50); // ballons 레이블 사이즈 설정
					v.add(balloons); // v에 ballons 레이블 추가
					add(v.get(cnt)); // 패널에 생성한 ballons 레이블 추가
					v.get(cnt).setLocation(e.getPoint()); // 생성한 ballons 레이블의 위치를 마우스 클릭한 곳으로 설정
					bt = new BubbleThread(v.get(cnt)); // 생성한 ballons 레이블의 bt 스레드 생성
					bt.start(); // bt 스레드 실행
					if(cnt==30) cnt = 0; // vector 공간 효율성을 위해 30개까지만 생성 가능
					else cnt++;
				}
			});
		}
	}
	public static void main(String[] args) {
		new BubbleGame();
	}
}
