package chapter21;

import java.util.*;

public class Listing21_08TestMap {
	public static void main(String[] args) {
		// Create a HashMap
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Smith", Integer.valueOf(30));
		hashMap.put("Anderson", 31);
		hashMap.put("Lewis", 29);
		hashMap.put("Cook", 29);

		System.out.println("Display entries in HashMap");
		System.out.println(hashMap + "\n");
		
		System.out.println("hashMap keys() size is: " + hashMap.keySet().size());
		System.out.println("hashMap values() size is: " + hashMap.values().size());
		System.out.println("hashMap freq() of 29 is: " + 
		Collections.frequency(hashMap.values(), 29));
		// System.out.println("hashMap values()" + hashMap.values());


		// Create a TreeMap from the preceding HashMap
		Map<String, Integer> treeMap = new TreeMap<>(hashMap);
		System.out.println("Display entries in ascending order of key");
		System.out.println(treeMap);
 
		// Create a LinkedHashMap with ACCESS ORDER for access order (true)
		// if false, then always insertion order
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
		linkedHashMap.put("Smith", 30);
		linkedHashMap.put("Anderson", 31);
		linkedHashMap.put("Lewis", 29);
		linkedHashMap.put("Cook", 29);
		System.out.println("Display entries in insertion order before any access");
		System.out.println(linkedHashMap);

		// Display the age for Lewis
		System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));

		System.out.println("Display entries in LinkedHashMap with access order");
		System.out.println(linkedHashMap);

		// Display each entry with name and age
		System.out.print("\nNames and ages are ");
		treeMap.forEach((name, age) -> System.out.print(name + ": " + age + " "));

		// I tested this myself
		System.out.print("\nNames and ages are ");
		linkedHashMap.forEach((name, age) -> System.out.print(name + ": " + age + " "));

	}
}

// Display entries in HashMap
// {Lewis=29, Smith=30, Cook=29, Anderson=31}
//
// Display entries in ascending order of key
// {Anderson=31, Cook=29, Lewis=29, Smith=30}
//
// The age for Lewis is 29
// Display entries in LinkedHashMap
// {Smith=30, Anderson=31, Cook=29, Lewis=29}
//
// Names and ages are Anderson: 31 Cook: 29 Lewis: 29 Smith: 30
// Names and ages are Smith: 30 Anderson: 31 Cook: 29 Lewis: 29
