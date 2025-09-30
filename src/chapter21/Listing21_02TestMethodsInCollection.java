package chapter21;

public class Listing21_02TestMethodsInCollection {
	public static void main(String[] args) {
		// Create set1
		java.util.Set<String> set1 = new java.util.HashSet<>();

		// Add strings to set1
		set1.add("London");
		set1.add("Paris");
		set1.add("New York");
		set1.add("San Francisco");
		set1.add("Beijing");

		System.out.println("set1 is " + set1);
		System.out.println(set1.size() + " elements in set1");

		// Delete a string from set1
		set1.remove("London");
		System.out.println("\nset1 is " + set1);
		System.out.println(set1.size() + " elements in set1");

		// Create set2
		java.util.Set<String> set2 = new java.util.HashSet<>();

		// Add strings to set2
		set2.add("London");
		set2.add("Shanghai");
		set2.add("Paris");
		System.out.println("\nset2 is " + set2);
		System.out.println(set2.size() + " elements in set2");

		System.out.println("\nIs Taipei in set2? " + set2.contains("Taipei"));

		set1.addAll(set2); // Returns:true if this set changed as a result of the call
		System.out.println("\nAfter adding set2 to set1, set1 is " + set1);

		set1.removeAll(set2);
		System.out.println("After removing set2 from set1, set1 is " + set1);

		set1.retainAll(set2);
		System.out.println("After removing common elements in set2 " + "from set1, set1 is " + set1);
	}
}

// set1 is [San Francisco, Beijing, New York, London, Paris]
// 5 elements in set1
//
// set1 is [San Francisco, Beijing, New York, Paris]
// 4 elements in set1
//
// set2 is [Shanghai, London, Paris]
// 3 elements in set2
//
// Is Taipei in set2? false
//
// After adding set2 to set1, set1 is [San Francisco, Beijing, New York,
// Shanghai, London, Paris]
// After removing set2 from set1, set1 is [San Francisco, Beijing, New York]
// After removing common elements in set2 from set1, set1 is []

