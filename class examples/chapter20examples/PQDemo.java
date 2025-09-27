package chapter20;
import java.util.*;

public class PQDemo {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.offer("Paul");
		pq.offer("David");
		pq.offer("John");
		pq.offer("Mary");
		
		while (pq.size()!=0)
			System.out.println(pq.remove());
	}

}
