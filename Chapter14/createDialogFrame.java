package _6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class createDialogFrame extends JFrame {
	private Container contentPane;
	private JButton cal = new JButton("calculate"); // dialog에 진입 시켜줄 JButton 객체 생성
	private JLabel result = new JLabel("계산 결과 출력"); // 계산 결과를 보여줄 JLabel 객체 생성
	private CalculationDialog dialog; // dialog 생성

	class CalculationDialog extends JDialog { // 계산을 위한 값입력 Dialog 정의
		private JTextField[] tfs = new JTextField[2]; // 값 입력 받을 JTextFiled 객체 배열 생성
		private JButton Add = new JButton("Add"); // JButton 객체 생성
		private JLabel text = new JLabel("두 수를 더합니다."); // JLabel 객체 생성

		public CalculationDialog(JFrame frame, String title) { // dialog 생성자
			super(frame, title, true); // 모달 다이얼로그 생성을 위한 JDialog 생성자 이용
			setLayout(null);
			text.setSize(100, 30);
			text.setLocation(60, 0);
			add(text); // dialog에 text 객체 추가
			for (int i = 0; i < tfs.length; i++) { // tfs 객체 배열 수만큼 dialog에 추가
				tfs[i] = new JTextField(10);
				tfs[i].setSize(130, 25);
				tfs[i].setLocation(45, 30 + i * 30);
				tfs[i].addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) { // tfs에서 키를 입력했을 경우
						if (e.getKeyChar() < 48 || e.getKeyChar() > 57) { // 숫자 ASCII CODE가 아닐 경우
							JOptionPane.showMessageDialog(null, e.getKeyChar() + "는 숫자 키가 아닙니다.\n숫자를 입력하세요.", "경고",
									JOptionPane.OK_OPTION); // 경고창을 띄워줌.
							e.consume(); // 입력한 값을 무효시킴.
						}
					}
				});
				add(tfs[i]);
			}
			Add.setSize(80, 30);
			Add.setLocation(70, 90);
			add(Add); // dialog에 Add 객체 추가
			setSize(230, 230);

			Add.addActionListener(new ActionListener() { // Add JButton 클릭 이벤트 추가 및 익명 클래스 정의
				public void actionPerformed(ActionEvent e) {
					setVisible(false); // dialog 창을 숨김
					result.setText(Integer.toString(getResult())); // result JLabel의 Text값을 getResult 함수 리턴 값으로 설정
				}
			});
		}

		public int getResult() {
			int result = 0;
			for (int i = 0; i < tfs.length; i++) {
				result += Integer.parseInt(tfs[i].getText()); // tfs 값들을 result에 더함
			}
			return result; // result 리턴
		}
	}

	public createDialogFrame() { // JFrame 생성자 정의
		super("다이얼로그 만들기");
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout()); // FlowLayout으로 설정
		dialog = new CalculationDialog(this, "CalculationDialog"); // dialog 객체 생성
		cal.addActionListener(new ActionListener() { // cal JButton 버튼 이벤트 추가 및 익명 클래스 정의
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true); // dialog 보이게 표시
			}
		});
		contentPane.add(cal); // cal Button contentPane에 추가
		result.setOpaque(true); // result JLabel 불투명하게 설정
		result.setBackground(Color.GREEN); // result JLabel 배경 설정
		contentPane.add(result); // resutl JLabel contentPane에 추가
		setSize(350, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new createDialogFrame();
	}
}
