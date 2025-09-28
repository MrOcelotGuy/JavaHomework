package chapter20;

import java.util.*;
public class PriorityQueueProblem {
	public static void main(String[] args) {
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		PriorityQueue<String> queue2 = new PriorityQueue<>(Collections.reverseOrder());
		queue1.offer("D");
		queue1.offer("B");
		queue1.offer("A");
		queue1.offer("C");
		queue2.offer("c");
		queue2.offer("d");
		queue2.offer("a");
		queue2.offer("b");
		while (queue1.size() > 0) {
			System.out.print(queue1.remove() + " ");
		}
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
	}
}
