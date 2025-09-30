package chapter21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

/* 
 * "How does Java check for equality of any objects"?
 * Written by Dr Takyiu Liu, West Valley College, CS Department, Fall 2020
 * 
 * First check the 2 object's hashCodes. If they don't have the same hashCode, they are not equal.
 * JVM DOES NOT even call equals() in this case.
 * If they have the same hashCode, then (and only then) execute object1.equals(object2).
 * 
 */

public class EqualityOfObjects {

	public static void main(String[] args) {
		
//		Item1 item1_1 = new Item1(100);
//		Item1 item1_2 = new Item1(100);
//		System.out.println(item1_1.hashCode());
//		System.out.println(item1_2.hashCode());
//		System.out.println(item1_1 == item1_2);
//		System.out.println(item1_1.equals(item1_2)); 
//		System.out.println();
		

//		Item2 item2_1 = new Item2(100);
//		Item2 item2_2 = new Item2(100);
//		System.out.println(item2_1 == item2_2);
//		System.out.println(item2_1.equals(item2_2));
//		System.out.println();
		
		
		// not using polymorphism
//		Item3 item3_1 = new Item3(100);
//		Item3 item3_2 = new Item3(100);
//		System.out.println(item3_1 == item3_2);
//		// looking for Item3.equals(Item3)
//		System.out.println(item3_1.equals(item3_2)); 
		
		
//		Object item3_3 = new Item3(100);
//		Object item3_4 = new Item3(100);
//		System.out.println(item3_3 == item3_4);
//		// item3_3 is defined as Object type but constructed with Item3 constructed.
//		// this is a setup for polymorphism. 
//		// looking for Item3.equals(Object); 
//		// polymorphism fails because it is defined as Item3.equals(Item3) and override fails.
//		// so they move up inheritance to use the definition in Object class
//		System.out.println(item3_3.equals(item3_4)); 
//		System.out.println();
		
		
//		Item4 item4_1 = new Item4(100);
//		Item4 item4_2 = new Item4(100);
//		System.out.println(item4_1 == item4_2);
//		// item4_1 is defined as Item4 type
//		// looking for Item4.equals(Item4)
//		// no polymorphism
//		// In Item4 class, use Item4 object as actual parameter for formal parameter of Object type
//		System.out.println(item4_1.equals(item4_2)); 
		
		
//		Object item4_3 = new Item4(100);
//		Object item4_4 = new Item4(100);
//		System.out.println(item4_3 == item4_4);
//		// item4_3 is defined as Object type.
//		// looking for Object.equals(Object)
//		// found via polymorphism so use the definition of Item4.equals(Object) in Item4 class
//		System.out.println(item4_3.equals(item4_4)); 
//		System.out.println();
		
		
//		Set<Item4> set1 = new HashSet<>();
//		Object item4_5 = new Item4(100);
//		Object item4_6 = new Item4(100);
//		set1.add((Item4)item4_5);
//		set1.add((Item4)item4_6);
//		System.out.println(set1);
//		System.out.println();
		
		
//		Set<Item5> set2 = new HashSet<>();
//		Object item5_5 = new Item5(100);
//		Object item5_6 = new Item5(100);
//		Object item5_7 = new Item5(100);
//		set2.add((Item5)item5_5);
//		set2.add((Item5)item5_6);
//		set2.add((Item5)item5_7);
//		System.out.println(set2);
		
		
//		Set<Item5> set3 = new HashSet<>();
//		set3.add(new Item5(3));
//		set3.add(new Item5(4));
//		Set<Item5> set4 = new HashSet<>();
//		set4.add(new Item5(4));
//		set4.add(new Item5(3));
//		System.out.println(set3.hashCode());
//		System.out.println(set4.hashCode());
//		System.out.println(set3.equals(set4));
				
	}
}

class Item1 {
	int m;
	public Item1(int i) {
		m = i;
	}
	@Override
	public String toString() {
		return "<" + m + ">";
	}
}

class Item2 implements Comparable<Item2> {
	int m;
	public Item2(int i) {
		m = i;
	}
	@Override
	public int compareTo(Item2 item2) {
		return m - item2.m;
	}
	@Override
	public String toString() {
		return "<" + m + ">";
	}
}

class Item3 {
	int m;
	public Item3(int i) {
		m = i;
	}
	// Object class has equals(Object) defined
	// this has a different signature 
	public boolean equals(Item3 o) {
		return m == o.m;
	}
	@Override
	public String toString() {
		return "<" + m + ">";
	}
}

class Item4 {
	int m;
	public Item4(int i) {
		m = i;
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("Item4.equals(Object) called.");
		return m == ((Item4)o).m;
	}
	@Override
	public String toString() {
		return "<" + m + ">";
	}
}

class Item5 {
	int m;
	public Item5(int i) {
		m = i;
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("Item5.equals(Object) called for " + this);
		return m == ((Item5)o).m;
	}
	@Override
	public int hashCode() {
		System.out.println("Item5.hashCode() called for " + this);
		return m;
	}
	@Override
	public String toString() {
		return "<" + m + ">";
	}
}

