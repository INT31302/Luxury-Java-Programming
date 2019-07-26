import java.util.*;

abstract class Calc{
	protected int a, b;
	public void setValue(int a, int b) {this.a = a; this.b= b;}
	public abstract int calculate();
}

class Add extends Calc{
	public int calculate() {return a+b;}
}

class Sub extends Calc{
	public int calculate() {return a-b;}
}

class Mul extends Calc{
	public int calculate() {return a*b;}
}

class Div extends Calc{
	public int calculate() {return a/b;}
}
public class Calculator {
	public static void main(String[] args) {
		int num1, num2;
		char oper;
		Scanner s = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오>>");
		num1 = s.nextInt();
		num2 = s.nextInt();
		oper  = s.next().charAt(0);
		s.close();
		switch(oper) {
		case '+':
			Add a = new Add();
			a.setValue(num1, num2);
			System.out.println(a.calculate());
			break;
		case '-':
			Sub sub = new Sub();
			sub.setValue(num1, num2);
			System.out.println(sub.calculate());
			break;
		case '*':
			Mul m= new Mul();
			m.setValue(num1, num2);
			System.out.println(m.calculate());
			break;
		case '/':
			Div d = new Div();
			d.setValue(num1, num2);
			System.out.println(d.calculate());
			break;
		}
	}
}
