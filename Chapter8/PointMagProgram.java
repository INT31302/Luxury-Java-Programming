import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PointMagProgram extends JFrame {
    private JFrame jf = this;
    private HashMap<String, Integer> map = new HashMap<>(); // String 타입 Key와 Integer 타입 Value를 가지는 HashMap 생성
    private MyDialog dialog = null; // dialog 선언

    public PointMagProgram() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("입력");
        add(btn);
        btn.addActionListener(new ActionListener() { // 입력 버튼 눌렀을 시 이벤트 생성
            public void actionPerformed(ActionEvent e) {
                dialog = new MyDialog(jf); // dialog 생성
                dialog.setVisible(true); // dialog 보이게 설정
            }
        });
        setSize(200, 100);
        setVisible(true);
        System.out.println("** 포인트 관리 프로그램입니다 **");

    }

    class MyDialog extends JDialog {
        public MyDialog(JFrame frame) {
            super(frame, "이름과 포인트 입력 >>", true); // 모달 다이얼로그로 설정
            setSize(300, 300);
            setLayout(null);
            JLabel la = new JLabel("이름 입력");
            la.setBounds(0, 0, 100, 50);
            JTextField tf = new JTextField(10);
            tf.setBounds(100, 10, 100, 30);
            JLabel la2 = new JLabel("포인트 입력");
            la2.setBounds(0, 50, 100, 50);
            JTextField tf2 = new JTextField(10);
            tf2.setBounds(100, 60, 100, 30);
            JButton btn = new JButton("확인");
            btn.setBounds(0, 100, 100, 30);
            btn.addActionListener(new ActionListener() { // 확인 버튼 눌렀을 때 이벤트 생성
                public void actionPerformed(ActionEvent e) {
                    String a = tf.getText(); // tf 입력한 값을 a에 저장
                    int b = Integer.parseInt(tf2.getText()); // tf2에 입력한 값을 정수로 변환하여 b에 저장
                    if (map.containsKey(a)) // map에 a Key가 있을 경우
                        map.replace(a, map.get(a) + b); // a Key의 Value를 누적하여 저장
                    else // map에 a Key가 없을 경우
                        map.put(a, b); // map에 a Key를 가진 b Value 추가

                    Set<String> keys = map.keySet(); // keys에 map key들을 저장
                    keys.forEach(key -> System.out.print("(" + key + "," + map.get(key) + ")")); // forEach를 이용하여 map에
                                                                                                 // 있는 데이터들을 모두 출력
                    System.out.println();
                    MyDialog.this.dispose(); // 다이얼로그 종료
                }
            });
            add(la);
            add(la2);
            add(tf);
            add(tf2);
            add(btn);
        }
    }

    public static void main(String[] args) {
        new PointMagProgram();
    }
}