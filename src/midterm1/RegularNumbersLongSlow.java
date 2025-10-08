package midterm1;

import java.util.*;
public class RegularNumbersLongSlow {
	public static void main(String[] args)
    {
		System.out.println(slowRegularNumber(30));
	}
	public static long slowRegularNumber(int n) {
		List<Long> twos = new ArrayList<>();
		long twoPower = 1;
		for (int i = 0; i < n; i++) {
			twos.add(twoPower);
			twoPower *= 2;
		}
//		System.out.println(twos);
		List<Long> threes = new ArrayList<>();
		long threePower = 1;
		for (int i = 0; i < n; i++) {
			threes.add(threePower);
			threePower *= 3;
		}
//		System.out.println(threes);
		List<Long> fives = new ArrayList<>();
		long fivePower = 1;
		for (int i = 0; i < n; i++) {
			fives.add(fivePower);
			fivePower *= 5;
		}
//		System.out.println(fives);
		TreeSet<Long> set = new TreeSet<>();
		for (long i : twos)
			for (long j : threes)
				for (long k : fives)
					set.add(i * j * k);
		System.out.println(set);
		int counts = 0;
		Iterator<Long> it = set.iterator();
		// skip first (n-1) numbers
		while (counts < n - 1) {
			it.next(); 
			counts++;
		}
		return it.next();
	}
}
