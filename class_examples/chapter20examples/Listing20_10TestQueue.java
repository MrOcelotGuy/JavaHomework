package chapter20;

public class Listing20_10TestQueue {
	public static void main(String[] args) {
		java.util.Queue<String> queue = new java.util.LinkedList<>();
		queue.offer("Oklahoma");
		queue.offer("Indiana");
		queue.offer("Georgia");
		queue.offer("Texas");
		System.out.println(queue);

		while (queue.size() > 0)
			System.out.print(queue.poll() + " ");
		
		//queue.remove();
	}
}

// Oklahoma Indiana Georgia Texas