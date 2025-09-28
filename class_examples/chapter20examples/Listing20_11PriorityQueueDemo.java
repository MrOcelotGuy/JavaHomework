package chapter20;

import java.util.*;

public class Listing20_11PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		queue1.offer("Oklahoma");
		queue1.offer("Indiana");
		queue1.offer("Georgia");
		queue1.offer("Texas");
		System.out.println(queue1);

		System.out.println("Priority queue using Comparable:");
		while (queue1.size() > 0) {
			System.out.print(queue1.remove() + " ");
		}
		System.out.println();
		PriorityQueue<String> queue2 = new PriorityQueue<>(Collections.reverseOrder());
//		PriorityQueue<String> queue2 = new PriorityQueue<>(400, Collections.reverseOrder());
		queue2.offer("Oklahoma");
		queue2.offer("Indiana");
		queue2.offer("Georgia");
		queue2.offer("Texas");
		System.out.println(queue2);

		System.out.println("\nPriority queue using Comparator:");
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
	}
}

// Priority queue using Comparable:
// Georgia Indiana Oklahoma Texas
// Priority queue using Comparator:
// Texas Oklahoma Indiana Georgia
