package chapter20;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Expression to eval:");
		String expression = input.nextLine().trim();
		String token;
		Stack<Integer> stack = new Stack<>();
		String[] tokens = insertBlanks(expression).split("\\s+");
		for (String t : tokens) {
			int operand1, operand2;
			switch (t) {
			case "+":
				operand1 = stack.pop();
				operand2 = stack.pop();
				stack.push(operand2 + operand1);
				break;
			case "-":
				operand1 = stack.pop();
				operand2 = stack.pop();
				stack.push(operand2 - operand1);
				break;
			case "*":
				operand1 = stack.pop();
				operand2 = stack.pop();
				stack.push(operand2 * operand1);
				break;
			case "/":
				operand1 = stack.pop();
				operand2 = stack.pop();
				stack.push(operand2 / operand1);
				break;
			default:
				stack.push(Integer.parseInt(t));
				break;
			}
		}
		if (stack.size() == 1) 
			System.out.println(stack.pop());
		else
			System.out.println("Invalid postfix expression");
	}

	public static String insertBlanks(String s) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/')
				result.append(" " + s.charAt(i) + " ");
			else
				result.append(s.charAt(i));
		}
		return result.toString();

	}
}

// 12 9 * 1 2 3 + + /
