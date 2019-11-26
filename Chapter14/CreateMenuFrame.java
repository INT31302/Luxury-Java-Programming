package _1;

import javax.swing.*;
import java.awt.*;

public class CreateMenuFrame extends JFrame {
	public CreateMenuFrame() {
		super("메뉴 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		createMenu();
		setSize(350, 250);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu viewMenu = new JMenu("보기");

		viewMenu.add(new JMenuItem("화면확대"));
		viewMenu.add(new JMenuItem("쪽윤곽"));

		mb.add(new JMenu("파일"));
		mb.add(new JMenu("편집"));
		mb.add(viewMenu);
		mb.add(new JMenu("입력"));

		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new CreateMenuFrame();
	}
}
