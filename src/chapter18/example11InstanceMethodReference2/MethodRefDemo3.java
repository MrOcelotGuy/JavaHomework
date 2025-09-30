package example11InstanceMethodReference2;
// Use an instance method reference to refer to any instance. 

// A functional interface for numeric predicates that operate 
// on an object of type MyIntNum and an integer value. 
interface MyIntNumPredicate {
	boolean test(MyIntNum mv, int n);
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
}

class MethodRefDemo3 {
	public static void main(String args[]) {
		boolean result;

		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);

		// This makes inp refer to the instance method isFactor().
		MyIntNumPredicate inp = MyIntNum::isFactor;

		// The following calls isFactor() on myNum.
		result = inp.test(myNum, 3);
		if (result)
			System.out.println("3 is a factor of " + myNum.getNum());

		// The following calls isFactor() on myNum2.
		result = inp.test(myNum2, 3);
		if (!result)
			System.out.println("3 is a not a factor of " + myNum2.getNum());
	}
}

//3 is a factor of 12
//3 is a not a factor of 16