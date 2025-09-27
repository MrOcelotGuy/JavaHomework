package chapter20;

import chapter13.GeometricObject;
import chapter13.Rectangle;
import chapter13.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class Listing20_06TestComparator {
	public static void main(String[] args) {
		GeometricObject g1 = new Rectangle(5, 5);
		GeometricObject g2 = new Circle(5);

		GeometricObject g = max(g1, g2, new Listing20_05GeometricObjectComparator());

		System.out.println("The area of the larger object is " + g.getArea());
		
		GeometricObject[] objs = {new Circle(2), new Rectangle(3,4), new Rectangle(5,6), new Circle(6)};

		Arrays.sort(objs, new Listing20_05GeometricObjectComparator());
		for (GeometricObject go:objs)
			System.out.println(go);
	}

	public static GeometricObject max(GeometricObject g1, GeometricObject g2, Comparator<GeometricObject> c) {
		if (c.compare(g1, g2) > 0)
			return g1;
		else
			return g2;
	}
}

//The area of the larger object is 78.53981633974483