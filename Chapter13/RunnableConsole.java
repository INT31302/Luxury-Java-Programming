package _1;

import java.util.*;
class PrintRunnable implements Runnable{
	public void run() {
		System.out.println("������ ���� ����");
		for(int i=1; i<11; i++) System.out.print(i+" ");
		System.out.println();
		System.out.println("������ ���� ����");
	}
}
public class RunnableConsole {
	private Scanner s = new Scanner(System.in);
	public RunnableConsole() {
		System.out.print("�ƹ� Ű�� �Է� >> ");
		if(!s.nextLine().equals(" ")) {
			PrintRunnable pr = new PrintRunnable();
			pr.run();
		}
	}
	public static void main(String[] args) {
		new RunnableConsole();
	}
}
