package chapter21;

import java.util.*;

public class Listing21_01TestHashSet {
	public static void main(String[] args) {
		// Create a hash set
		Set<String> set = new HashSet<>();

		// Add strings to the set
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");

		System.out.println(set);
		
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");

		// Display the elements in the hash set
		System.out.println();
		for (String s : set) {
			System.out.print(s.toUpperCase() + " ");
		}

		// Process the elements using a forEach method
		System.out.println();
		// lambda expression
		set.forEach(x -> System.out.print(x.toLowerCase() + " "));
	}
}

// [San Francisco, Beijing, New York, London, Paris]
// San Francisco Beijing New York London Paris
// SAN FRANCISCO BEIJING NEW YORK LONDON PARIS
// san francisco beijing new york london paris
