package chapter20;
import java.util.*;

public class Listing20_03TestForEach {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<>();
		collection.add("New York");
		collection.add("Atlanta");
		collection.add("Dallas");
		collection.add("Madison");
		collection.forEach(e -> System.out.print(e.toUpperCase() + " "));
	}
}

//NEW YORK ATLANTA DALLAS MADISON 