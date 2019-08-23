import java.util.*;

interface IStack<T>{
	T pop();
	boolean push(T ob);
}
class MyStack<T> implements IStack<T>{
	ArrayList<T> l = null;
	public MyStack() {
		l = new ArrayList<>();
	}
	public T pop() {
		if(l.size() == 0) return null;
		else return l.remove(l.size()-1);
	}
	public boolean push(T ob) {
		l.add(ob);
		return true;
	}
}
public class InterfaceStack {
	public static void main(String[] args) {
		IStack<Integer> stack = new MyStack<Integer>();
		for(int i =0; i<10; i++) stack.push(i);
		while (true) {
			Integer n = stack.pop();
			if(n == null) break;
			System.out.print(n + " ");
		}
	}
}
