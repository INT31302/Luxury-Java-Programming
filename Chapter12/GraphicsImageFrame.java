package _10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.*;

public class GraphicsImageFrame extends JFrame{
   int x1,y1;
   int x,y;
   int t;
   private MyPanel panel = new MyPanel();
   public GraphicsImageFrame() {
      setTitle("12장 과제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(panel);
      panel.addMouseListener(new MyMouseListener());
      panel.addMouseMotionListener(new MyMouseMotionListener());
      setSize(500,500);
      setVisible(true);
      
   }
   
   class MyPanel extends JPanel{
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setColor(Color.RED);
         g.drawOval(x1-(x-x1)/2,y1-(y-y1)/2,t,t);
      }
   }
   
   class MyMouseListener implements MouseListener {

      public void mouseClicked(MouseEvent e) {
         
      }

      public void mousePressed(MouseEvent e) {
         x1=e.getX();
         y1=e.getY();
      }

      public void mouseReleased(MouseEvent e) {
		  System.out.println(x1+","+y1);
		  System.out.println(x+","+y);
		  System.out.println(x1-(x-x1));
		  System.out.println(y1-(y-y1));
		  t = (x1 - x > y1 - y)?  x1-(x-x1) : y1-(y-y1);
         repaint();
      }

      public void mouseEntered(MouseEvent e) {
         
      }
      
      public void mouseExited(MouseEvent e) {
         
      }
   
   }
   class MyMouseMotionListener implements MouseMotionListener{

      public void mouseDragged(MouseEvent e) {
         x = e.getX();
         y = e.getY();
         
      }

      public void mouseMoved(MouseEvent e) {
         
      }
      
   }


   
   
public static void main(String[] args) {
   new GraphicsImageFrame();
}   

}

