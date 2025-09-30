package chapter21;

import chapter13.*;
import chapter20.GeometricObjectComparator;
import java.util.*;

public class Listing21_05TestTreeSetWithComparator {
	public static void main(String[] args) {

		Set<GeometricObject> set = new TreeSet<>(new GeometricObjectComparator());
		set.add(new Rectangle(4, 5));
		// Create a tree set for geometric objects using a comparator
		// 2/26/2022 looks like they skip the steps in hashCode and goes straight to
		// compare()
//		set.add(new Circle(40));
		set.add(new Circle(40));
		set.add(new Rectangle(4, 1));
		set.add(new Rectangle(2, 10));

		// Display geometric objects in the tree set
		System.out.println("A sorted set of geometric objects");
		for (GeometricObject element : set)
			System.out.println("area = " + element.getArea());
	}
}
