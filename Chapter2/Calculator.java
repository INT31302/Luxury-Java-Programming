import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		double num1, num2;
		String oper;
		Scanner s = new Scanner(System.in);
		
		System.out.print("연산>>");
		num1 = s.nextDouble();
		oper = s.next();
		num2 = s.nextDouble();
    
		// if문 사용
		if(oper.equals("+"))
		{
			System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1+num2));
		}
		else if(oper.equals("-"))
		{
			System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1-num2));
		}
		else if(oper.equals("*"))
		{
			System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1*num2));
		}
		else if(oper.equals("/"))
		{
			if(num2 != 0)
			System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1/num2));
			else
				System.out.println("0으로 나눌 수 없습니다.");
		}
		
    // switch문 사용
		switch(oper)
		{
		case "+":
			System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1+num2));
			break;
		case "-":
			System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1-num2));
			break;
		case "*":
			System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1*num2));
			break;
		case "/":
			if(num2 != 0)
				System.out.println(num1+oper+num2+"의 계산 결과는 "+(num1/num2));
			else
				System.out.println("0으로 나눌 수 없습니다.");
			break;
		}
			s.close();
	}

}
