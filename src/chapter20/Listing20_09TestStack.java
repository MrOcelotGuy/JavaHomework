package chapter20;

import java.util.*;

public class Listing20_09TestStack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("Oklahoma");
		stack.push("Indiana");
		stack.push("Georgia");
		stack.push("Texas");
		System.out.println(stack.peek());
		System.out.println(stack);
		while (stack.size() > 0)
			System.out.print(stack.pop() + " ");
	}
}

// Texas
// Texas Georgia Indiana Oklahoma