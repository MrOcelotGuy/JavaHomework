package chapter21;

import java.util.*;

public class Listing21_03TestLinkedHashSet {
	public static void main(String[] args) {
		// Create a hash set
		Set<String> set = new LinkedHashSet<>();

		// Add strings to the set
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");

		System.out.println(set);

		// Display the elements in the hash set
		for (String element : set)
			System.out.print(element.toLowerCase() + " ");
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

//[London, Paris, New York, San Francisco, Beijing]
//london paris new york san francisco beijing 
//LONDON PARIS NEW YORK SAN FRANCISCO BEIJING 
//london paris new york san francisco beijing 
