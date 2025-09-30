/**
   This program demonstrates that an interface type may
   be used to create a polymorphic reference.
*/
package chapter18.retail;

public class PolymorphicInterfaceDemo {
	public static void main(String[] args) {
		CompactDisc cd = new CompactDisc("Greatest Hits", "Joe Looney Band", 18.95);
		DvdMovie movie = new DvdMovie("Wheels of Fury", 137, 12.95);
		System.out.println("Item #1: " + cd.getTitle());
		showPrice(cd);
		System.out.println("Item #2: " + movie.getTitle());
		showPrice(movie);
	}

	private static void showPrice(RetailItem item) {
		System.out.printf("Price: $%,.2f\n", item.getRetailPrice());
	}
}
