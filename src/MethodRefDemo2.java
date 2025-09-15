/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-09
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #4
 * Description: This program uses a functional interface and method reference to check if 2 numbers share a common factor
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration:
 */


// Use a method reference to an instance method.

// A functional interface for numeric predicates that operate
// on integer values.
interface IntPredicate {
	boolean test(int n);

}

// This class stores an int value and defines the instance
// method isFactor(), which returns true if its argument
// is a factor of the stored value.
class MyIntNum {
	private int v;

	MyIntNum(int x) {
		v = x;
	}

	int getNum() {
		return v;
	}

	// Return true if n is a factor of v.
	boolean isFactor(int n) {
		return (v % n) == 0;
	}

	boolean hasCommonFactor(int n) {
		// your work
        if(isFactor(n))
        {
            return true;
        }
        for(int i = n; i > 1; i--)
        {
            if(isFactor(i) && (n%i == 0))
                return true;
        }
        return false;
	}
}

public class MethodRefDemo2 {

	public static void main(String args[]) {
		boolean result;

		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);
        MyIntNum myNum3 = new MyIntNum(258);

		// Here, a method reference to isFactor on myNum is created.
		IntPredicate ip = myNum::isFactor;

		// Now, it is used to call isFactor() via test().
		result = ip.test(3);
		if (result)
			System.out.println("3 is a factor of " + myNum.getNum());

		// This time, a method reference to isFactor on myNum2 is created.
		// and used to call isFactor() via test().
		ip = myNum2::isFactor;
		result = ip.test(3);
		if (!result)
			System.out.println("3 is not a factor of " + myNum2.getNum());

		// your work
        ip = myNum3::hasCommonFactor;
        result = ip.test(284);
        if (result)
        {
            System.out.println("284 has a common factor with " + myNum3.getNum());
        }
        else
        {
            System.out.println("284 does not have a common factor with " + myNum3.getNum());
        }


	}
}

//        3 is a factor of 12
//        3 is not a factor of 16
//        284 has a common factor with 258
//
//Process finished with exit code 0
