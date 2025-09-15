/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-09
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #3
 * Description: The program uses a lambda expression and an interface in order to calculate factorials
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: My father helped me by explaining to me what I didn't understand about how to use lambdas
 */


interface NumericFunc
{
	int func(int n);

}

class FactorialLambdaDemo {
	public static void main(String[] args)  //professor "String args[]" looks weird to me
    {

		// This block lambda computes the factorial of an int value.

    NumericFunc factorial = (x) -> {
        //made a factorial lambda expression
        int result = x;
        for(int i = 1; i < x; i++)
        {
            result *= i;
        }
        return result;

    };

		System.out.println("The factorial of 3 is " + factorial.func(3));
		System.out.println("The factorial of 5 is " + factorial.func(5));
		System.out.println("The factorial of 9 is " + factorial.func(9));
        // also factorial was misspelled so I corrected it
	}
}

// The factorial of 3 is 6
// The factorial of 5 is 120
// The factorial of 9 is 362880
//
// Process finished with exit code 0