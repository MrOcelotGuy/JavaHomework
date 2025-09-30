package example13PredefinedFunctionalInterfaces;
// Use the Predicate built-in functional interface. 

// Import the Function interface. 
import java.util.function.Predicate;

class UsePredicateInterface {
	public static void main(String args[]) {

		// This lambda uses Predicate<Integer> to determine
		// if a number is even.
		Predicate<Integer> isEven = (n) -> (n % 2) == 0;

		if (isEven.test(4))
			System.out.println("4 is even");

		if (!isEven.test(5))
			System.out.println("5 is odd");
	}
}

//4 is even
//5 is odd