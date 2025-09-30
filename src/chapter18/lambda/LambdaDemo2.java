/**
   This program demonstrates a lambda expression
   that uses a final local variable.
*/

package chapter18.lambda;

import java.util.Scanner;

public class LambdaDemo2 {
	public static void main(String[] args) {
		final int factor = 10;
		int num;
		Scanner keyboard = new Scanner(System.in);
		IntCalculator multiplier = x -> x * factor;
		System.out.print("Enter an integer number: ");
		num = keyboard.nextInt();
		System.out.println("Multiplied by 10, that number is " + multiplier.calculate(num));
	}
}
