package chapter20;

import java.util.Arrays;

public class Listing20_07SortStringByLength {
	public static void main(String[] args) {
		String[] cities = { "Atlanta", "Savannah", "New York", "Dallas" };

		java.util.Arrays.sort(cities); // lexicographic order
		java.util.Arrays.sort(cities, new MyComparator());
		java.util.Arrays.sort(cities, (s1, s2) -> s1.length() - s2.length());

		for (String s : cities) {
			System.out.print(s + " ");
		}
	}

	public static class MyComparator implements java.util.Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	}
}

//Dallas Atlanta Savannah New York 