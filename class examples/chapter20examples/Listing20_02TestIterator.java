 package chapter20;

import java.util.*;

public class Listing20_02TestIterator {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<>();
		collection.add("New York");
		collection.add("Atlanta");
		collection.add("Dallas");
		collection.add("Madison");

		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().toUpperCase() + " ");
		}
		System.out.println();
		
		Collection<Integer> collection2 = new ArrayList<>();
		for (int i=0; i<10; i++) 
			collection2.add(i*10);
		System.out.println(collection2);
		Iterator<Integer> iterator2 = collection2.iterator();
		iterator2.next();
		iterator2.next();
		iterator2.remove(); // the last element obtained with next()
		// from this point, you have to do some next() before remove()
		System.out.println(collection2);
	}
}

//NEW YORK ATLANTA DALLAS MADISON 