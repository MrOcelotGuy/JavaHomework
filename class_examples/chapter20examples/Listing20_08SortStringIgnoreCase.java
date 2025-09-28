package chapter20;

import java.util.Collections;

public class Listing20_08SortStringIgnoreCase {
	public static void main(String[] args) {
		java.util.List<String> cities = java.util.Arrays.asList("Atlanta", "Savannah", "new York", "dallas");
		cities.sort(null);
		for (String s : cities)
			System.out.print(s + " ");

		cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		for (String s : cities)
			System.out.print(s + " ");

		Collections.sort(cities);
		for (String s : cities)
			System.out.print(s + " ");
		
		Collections.sort(cities, (s1, s2) -> s1.compareToIgnoreCase(s2));
		for (String s : cities)
			System.out.print(s + " ");

		Collections.sort(cities, String::compareToIgnoreCase);
		for (String s : cities)
			System.out.print(s + " ");

	}
}

// Atlanta dallas new York Savannah