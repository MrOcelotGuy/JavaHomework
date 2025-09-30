package chapter20;

import java.util.Comparator;

public class Listing20_08SortStringIgnoreCase1 {
	public static void main(String[] args) {
		java.util.List<String> cities = java.util.Arrays.asList("Atlanta", "Savannah", "new York", "dallas");
		cities.sort(null);
		for (String s : cities) {
			System.out.print("\n" + s + " ");
		}
		IgnoreCaseStringComparator ignoreCaseStringComparator = new IgnoreCaseStringComparator();
		cities.sort(ignoreCaseStringComparator);

		for (String s : cities) {
			System.out.print("\n" + s + " ");
		}
	}
}

class IgnoreCaseStringComparator implements Comparator<String>, java.io.Serializable {
	public int compare(String s1, String s2) {
		return s1.toLowerCase().compareTo(s2.toLowerCase());
	}
}

// Atlanta
// Savannah
// dallas
// new York
// Atlanta
// dallas
// new York
// Savannah
