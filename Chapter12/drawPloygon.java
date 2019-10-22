package _7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class drawPloygon extends JFrame {
	MyPanel panel = new MyPanel();
	public drawPloygon() {
		super("마우스로 폐다각형 그리기");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setContentPane(panel);
		 
		 setSize(300,300);
		 setVisible(true);
	}
	class MyPanel extends JPanel{
		private ArrayList<Integer> PointX = new ArrayList<>();
		private ArrayList<Integer> PointY= new ArrayList<>();
		private int[] x= {0};
		private int[] y= {0};
		private int cnt = 0;
		
		public MyPanel(){
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					PointX.add(e.getX());
					PointY.add(e.getY());
					cnt++;
					x = new int[cnt];
					y = new int[cnt];
					for(int i =0; i<cnt; i++) {
						x[i] = PointX.get(i);
						y[i] = PointY.get(i);
					}
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			g.drawPolygon(x, y, cnt);
		}
	}
	public static void main(String[] args) {
		new drawPloygon();
	}
}
