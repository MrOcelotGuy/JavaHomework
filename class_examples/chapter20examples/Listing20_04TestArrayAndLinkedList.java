package chapter20;

import java.util.*;

public class Listing20_04TestArrayAndLinkedList {
	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(1); // 1 is autoboxed to new Integer(1)
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, 10);
		arrayList.add(3, 30);
		System.out.println(arrayList);
		
		//arrayList.remove(new Integer(3));
		arrayList.remove(Integer.valueOf(3));
		arrayList.remove(3);
		System.out.println(arrayList);


		LinkedList<Object> linkedList = new LinkedList<>(arrayList);
		linkedList.add(1, "red");
		linkedList.removeLast();
		linkedList.addFirst("green");
		System.out.println(linkedList);

		System.out.println("Display the linked list forward:");
		ListIterator<Object> listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
		System.out.println("Display the linked list backward:");
		listIterator = linkedList.listIterator(linkedList.size());
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
		System.out.println();
		System.out.println("Display the linked list backward:");
		for (int i = linkedList.size() - 1; i >= 0; i--) {
			System.out.print(linkedList.get(i) + " ");
		}
	
	}
}

