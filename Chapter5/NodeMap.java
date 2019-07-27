import java.util.*;

abstract class Shape{
	private Shape next;
	public Shape() {next = null;}
	public void setNext(Shape obj) {next = obj;}
	public Shape getNext() {return next;}
	public abstract void draw();
}

class Line extends Shape{
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape{
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape{
	public void draw() {
		System.out.println("Circle");
	}
}

public class NodeMap{
	private Shape start = null, last = null;
	private Scanner s = new Scanner(System.in);
	private void add(int num) {
		Shape obj = null ;
		switch(num) {
		case 1:
			obj = new Line();
			break;
		case 2:
			obj = new Rect();
			break;
		case 3:
			obj = new Circle();
			break;
		}
		if(start == null) { //생성된 게 없을 경우
			start = last = obj;
		}
		else { //생성 된 게 있을 경우
			last.setNext(obj); //마지막 노드에서 현재 노드를 가리킴
			last = obj; // 현재 노드를 마지막 노드로 변경
		}
	}
	private void del(int num) {
		Shape cur = start, temp = start;
		int i;
		if(num == 1)
			if(start == last) start = last = null; // 노드가 하나일 때
			else start = start.getNext(); //노드가 하나 이상일 때
		else {
			for(i = 1; i<num; i++) {
				temp = cur;
				cur = cur.getNext();
				if(cur == null) {
					System.out.println("삭제할 수 없습니다.");
					return;
				}
			}
				temp.setNext(cur.getNext());
				last = temp;
		}
	}
	private void show() {
		Shape p = start;
		if(start == null) System.out.println("표시할 도형이 없습니다.");
		else
		{
			while(p != null) {
			p.draw();
			p = p.getNext();
			}
		}
	}
	
	public void run() {
		int menu;
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			menu = s.nextInt();
			try {
				switch(menu) {
				case 1:
					System.out.print("Line(1), Rect(2), Circle(3)>>");
					menu = s.nextInt();
					add(menu);
					break;
				case 2:
					System.out.print("삭제할 도형의 위치>>");
					menu = s.nextInt();
					del(menu);
					break;
				case 3:
					show();
					break;
				case 4:
					System.out.println("beauty을 종료합니다,");
					s.close();
					return;
				}
			}
			catch(Exception e){
				System.out.println("오류가 발생하였습니다.\nbeauty을 종료합니다.");
				s.close();
				return;
			}
		}
	}
	public static void main(String[] args) {
		NodeMap GraphicEditor = new NodeMap();
		GraphicEditor.run();
	}
}
