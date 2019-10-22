package _8;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Circle{ // Circle 클래스 정의
    int x, y;
    int radius;
    public Circle(int startX, int startY){ // 객체가 생성될 때 마우스 좌표 저장
        x = startX;
        y = startY;
    }
    public void setRadius(int radius){ // 반지름 설정
        this.radius = radius;
    }
}
public class PaintCircle extends JFrame{
    private MyPanel panel = new MyPanel(); // MyPanel 객체 생성
    private int cnt = 0; // 생성된 Circle 객체 확인용
    private Vector<Circle> v = new Vector<Circle>(); // Circle 객체를 담을 벡터 생성
    public PaintCircle(){
        super("마우스로 원 그리기"); // 프로그램 이름 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 눌렀을 시 프로그램 종료시키기
        setContentPane(panel); // 현재 JFrame에 panel 붙이기
        setSize(800,450);// 사이즈 설정
        setVisible(true);// 창 보이게 설정
        addMouseListener(new MyMouseListener()); // JFrame에 마우스 리스너 추가
        addMouseMotionListener(new MyMouseListener()); // JFrame에 마우스 모션 리스너 추가
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
        super.paintComponents(g); //필요한 부분에만 칠하기 위해 사용
        g.setColor(Color.MAGENTA); // 색 설정
        if(!v.isEmpty()) // 백터 값이 비어있지 않을 때만 실행 (첫 실행시 에러 방지용)
            for(int i =0; i<v.size(); i++){ // 백터에 저장된 만큼 실행
                g.drawOval(v.get(i).x-(v.get(i).radius), v.get(i).y - (v.get(i).radius),
            v.get(i).radius*2, v.get(i).radius*2); // 마우스가 클릭된 위치에서 반지름만큼 원을 그리는 시작 좌표를 수정해줌. 높이와 너비는 지름으로 설정
            }
        }
    }
    class MyMouseListener extends MouseAdapter{ // 마우스 이벤트 리스너 정의
        int startX, startY;
        public void mousePressed(MouseEvent e){ // 마우스를 눌렀을 때
            startX = e.getX(); // 마우스 위치의 x값을 startX에 저장
            startY = e.getY(); // 마우스 위치의 y값을 startY에 저장
            v.add(new Circle(startX,startY)); // Circle객체를 생성하고 백터에 추가
        }
        public void mouseDragged(MouseEvent e){ // 마우스를 드래그 했을 때
            int radius;
            if(Math.abs(v.get(cnt).x-e.getX())>Math.abs(v.get(cnt).y-e.getY())) // x 이동 값과 y 이동 값 차를 절대값으로 구하여 차가 가장 큰 값을 radius로 사용
                radius = (int)Math.abs(v.get(cnt).x-e.getX());
                else radius = (int)Math.abs(v.get(cnt).y-e.getY());
            v.get(cnt).setRadius(radius); // 백터 안에 들어가있는 Circle 객체에 radius 저장
            repaint(); // 다시 그리기
        }
        public void mouseReleased(MouseEvent e){ // 마우스를 뗐을 경우
            cnt = v.size(); // cnt 값을 백터에 저장된 사이즈로 바꿈
        }
    }
    public static void main(String[] args) {
        new PaintCircle(); // 객체 생성
    }
}