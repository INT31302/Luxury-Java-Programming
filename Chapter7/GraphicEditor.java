package _10;
import java.util.*;

abstract class Shape{
	public void paint() {draw();}
	abstract public void draw();
}

class Circle extends Shape{
	public void draw() {System.out.println("Circle");}
}

class Line extends Shape{
	public void draw() {System.out.println("Line");}
}

class Rect extends Shape{
	public void draw() {System.out.println("Rect");}
}
public class GraphicEditor {
	private Scanner scanner = new Scanner(System.in);
	private Vector<Shape> v = new Vector<>();
	public GraphicEditor(){
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
	}
	public void insert() {
		int shape;
		System.out.print("Line(1), Rect(2), Circle(3)>>");
		try{
			shape = scanner.nextInt();
			switch(shape)
			{
			case 1:
				v.add(new Line());
				break;
			case 2:
				v.add(new Rect());
				break;
			case 3:
				v.add(new Circle());
				break;
			}
		}
		catch(Exception e) {
			System.out.println("오류가 발생하였습니다. 프로그램을 종료합니다.");
			scanner.close();
			return;
		}
	}
	public void delete() {
		int index;
		System.out.print("삭제할 도형의 위치>>");
		try {
			index = scanner.nextInt();
			if(v.size()>=index) v.remove(index-1);
			else System.out.println("삭제할 수 없습니다.");
		}
		catch(Exception e) {
			System.out.println("오류가 발생하였습니다. 프로그램을 종료합니다.");
			scanner.close();
			return;
		}
	}
	public void show() {
		Iterator<Shape> it = v.iterator();
		while(it.hasNext()) {
			it.next().paint();
		}
	}
	public void run() {
		int menu;
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			menu = scanner.nextInt();
			switch(menu) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				show();
				break;
			case 4:
				System.out.println("beauty을 종료합니다");
				scanner.close();
				return;
			}
		}
	}
	public static void main(String[] args) {
		GraphicEditor ge = new GraphicEditor();
		ge.run();
	}
}
