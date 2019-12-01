package _2;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;

public class LoadingImageFrame extends JFrame {
	private ImageIcon icon = null;
	private Image img = null;

	public LoadingImageFrame() {
		super("메뉴로 배경 이미지 로딩하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new imgPanel(), BorderLayout.CENTER); // Container 중앙에 imgPanel을 생성해줌
		createMenu(); // createMenu 함수 실행
		setSize(350, 350);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar(); // JMenuBar 객체 생성
		JMenu file = new JMenu("파일"); // "파일" 이름을 가진 JMenu 객체 생성
		JMenuItem open = new JMenuItem("열기"); // "열기" 이름을 가진 JMenu의 Item 생성
		file.add(open); // file 객체에 open MenuItem 추가
		open.addActionListener(new ActionListener() { // open 이벤트 추가
			private JFileChooser chooser = new JFileChooser(); // JFileChooser 객체 생성

			public void actionPerformed(ActionEvent e) { // open을 눌렀을 때 실행할 이벤트
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg"); // JPG 정보를 가진 파일 필터
																									// 객체 생성
				chooser.setFileFilter(filter); // chooser에 filter로 필터 적용
				int ret = chooser.showOpenDialog(null); // FileChooser Dialog를 띄워주고 결과값을 ret에 저장
				if (ret != JFileChooser.APPROVE_OPTION) { // 열기 버튼을 누르지 않았을 경우
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE); // 경고창을
																												// 띄어줌
					return; // 이벤트 강제 종료 시킴
				}
				String filePath = chooser.getSelectedFile().getPath(); // chooser에서 선택한 파일의 경로를 filePathd에 저장
				icon = new ImageIcon(filePath); // filePath을 ImageIcon화 시켜 저장
				img = icon.getImage(); // ImageIcon화 되있는 파일을 Image화 시켜 img에 저장
				repaint(); // 다시 그리기
			}
		});
		mb.add(file); // mb 객체에 file 메뉴 추가
		setJMenuBar(mb); // mb를 이용하여 JMenuBar를 JFrame에 설정
	}

	class imgPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // img를 창 전체에 그려줌.
		}
	}

	public static void main(String[] args) {
		new LoadingImageFrame();
	}
}
