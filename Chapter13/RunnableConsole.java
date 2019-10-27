package _1;

import java.util.*;
class PrintRunnable implements Runnable{
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int i=1; i<11; i++) System.out.print(i+" ");
		System.out.println();
		System.out.println("스레드 실행 종료");
	}
}
public class RunnableConsole {
	private Scanner s = new Scanner(System.in);
	public RunnableConsole() {
		System.out.print("아무 키나 입력 >> ");
		if(!s.nextLine().equals(" ")) {
			PrintRunnable pr = new PrintRunnable();
			pr.run();
		}
	}
	public static void main(String[] args) {
		new RunnableConsole();
	}
}
