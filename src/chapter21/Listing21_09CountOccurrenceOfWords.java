package chapter21;

import java.util.*;

public class Listing21_09CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning.    Have a good morning. " + "Have a good visit. Have a fun trip!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
		// String[] words = text.split("[\\s+]");
		String[] words = text.split("[\\s+\\p{P}]");
//		\p{P} or \p{Punctuation}: any kind of punctuation character.
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Display key and value for each entry
		map.forEach((k, v) -> System.out.println(k + "\t" + v));
	}
}

// a 2
// class 1
// fun 1
// good 3
// have 3
// morning 1
// visit 1
