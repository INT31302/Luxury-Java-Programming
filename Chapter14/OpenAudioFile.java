package _7;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class OpenAudioFile extends JFrame {
	private Container c;
	private JLabel label = new JLabel("오디오 파일을 선택하세요");
	private Clip clip = null;

	public OpenAudioFile() {
		super("오디오 파일을 찾아 연주/종료 제어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		label.setFont(new Font("Gothic", Font.PLAIN, 15));
		c.add(label);
		createMenuBar();
		setSize(550, 200);
		setVisible(true);
	}

	private void createMenuBar() {
		JMenuBar mb = new JMenuBar();
		JMenu Audio = new JMenu("오디오");
		JMenuItem[] items = { new JMenuItem("연주"), new JMenuItem("종료") };
		for (int i = 0; i < items.length; i++) {
			Audio.add(items[i]);
			items[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					System.out.println(cmd);
					switch (cmd) {
					case "연주":
						if (clip != null && clip.isActive()) {
							clip.close();
						}
						loadAudio();
						break;
					case "종료":
						if (clip != null && clip.isActive()) {
							clip.close();
							label.setText("연주를 종료합니다.");
						}
						break;
					}
				}
			});
		}
		mb.add(Audio);
		setJMenuBar(mb);
	}

	private void loadAudio() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filters = new FileNameExtensionFilter("Audio Files(wav, au, mid, rmf)", "wav", "au",
				"mid", "rmf");
		chooser.setFileFilter(filters);
		int ret = chooser.showOpenDialog(null);
		if (ret != chooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				File audioFile = new File(chooser.getSelectedFile().getPath());
				AudioInputStream AudioStream = AudioSystem.getAudioInputStream(audioFile);
				clip = AudioSystem.getClip();
				clip.open(AudioStream);
				clip.start();
				label.setText(audioFile.getName() + " 를 연주하고 있습니다.");
				clip.addLineListener(new LineListener() {

					public void update(LineEvent e) {
						if (e.getType() == LineEvent.Type.STOP) {
							try {
								label.setText(audioFile.getName() + " 를 연주가 끝났습니다.");
								AudioStream.close();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}

					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new OpenAudioFile();
	}
}