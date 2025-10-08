package chapter21;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnmodifiableSetExample {
    public static void main(String[] args) {
        // Create a modifiable set
        Set<String> modifiableSet = new HashSet<>();
        modifiableSet.add("Apple");
        modifiableSet.add("Banana");
        modifiableSet.add("Cherry");

        // Wrap it to make it unmodifiable
        Set<String> unmodifiableSet = Collections.unmodifiableSet(modifiableSet);

        System.out.println("Unmodifiable Set: " + unmodifiableSet);

        // This line would throw UnsupportedOperationException if uncommented
        unmodifiableSet.add("Date");

        // Modifying the original set will reflect in the unmodifiable set
        modifiableSet.add("Date");
        System.out.println("After modifying original set: " + unmodifiableSet);
    }
}
