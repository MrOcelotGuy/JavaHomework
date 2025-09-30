package chapter21;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Smith", Integer.valueOf(30));
		hashMap.put("Anderson", 31);
		hashMap.put("Lewis", 29);
		hashMap.put("Cook", 29);
		System.out.println(hashMap.keySet());
		System.out.println(hashMap.values());
		System.out.println(hashMap.entrySet());
		System.out.println(hashMap);
		System.out.println(hashMap.toString());
		System.out.println(hashMap.keySet().contains("Smith"));
		System.out.println(hashMap.get("Smith"));
	}

}
