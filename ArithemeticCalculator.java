package CalculatorJava;
import java.util.Scanner;
	public class ArithemeticCalculator {
		
		public static void main(String[] args) {
		    
			int num1 =0;
			int num2 = 0;
			char Operator;
			double answer =0.0;
			Scanner scan = new Scanner(System.in);
			System.out.println("please enter your first number");
			num1 = scan.nextInt();
			System.out.println("please enter your second number");
			num2 = scan.nextInt();
			System.out.println("which operator ");
			Operator = scan.next().charAt(0);
		
			switch(Operator) {
			case'+' : answer = num1 + num2;
			        break;
			case'-' : answer = num1 - num2;
			        break;
			case'*' : answer = num1 * num2;
			        break;
			case'/' : answer = num1 / num2;
			        break;
			}
			System.out.println(num1+" "+Operator+" "+num2+" "+answer);
		 }
	 

	}


