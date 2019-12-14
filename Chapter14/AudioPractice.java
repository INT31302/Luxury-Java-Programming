package _5;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AudioPractice extends JFrame {

	private MyPanel panel = new MyPanel();

	public AudioPractice() {
		super("오디오 시작 중단 연습");
		setContentPane(panel);
		setSize(400, 200);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private String song = "audio\\hiphop.wav";
		private JLabel result = new JLabel(song + " 연주 중");
		private Clip clip;

		public MyPanel() {
			setLayout(new FlowLayout());
			result.setFont(new Font("Gothic", Font.PLAIN, 15));
			add(result);
			loadAudio(song);
			addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					result.setText(song + " 연주 계속");
					clip.start();
				}

				public void mouseExited(MouseEvent e) {
					result.setText(song + " 연주 일시 중단");
					clip.stop();
				}
			});
		}

		private void loadAudio(String pathName) {
			try {
				File audioFile = new File(pathName);
				AudioInputStream AudioStream = AudioSystem.getAudioInputStream(audioFile);
				clip = AudioSystem.getClip();
				clip.open(AudioStream);
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new AudioPractice();
	}
}
