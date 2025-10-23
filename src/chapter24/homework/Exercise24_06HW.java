package chapter24.homework;

import java.util.Comparator;

public class Exercise24_06HW {
  public static void main(String[] args) {
    new Exercise24_06HW();
  }

  public Exercise24_06HW() {

    // construct queue with a comparator object, say
    // s1, s2 with compareToIgnoreCase
	/*
    queue.enqueue("Macon");
    queue.enqueue("Atlanta");
    queue.enqueue("Savannah");
    queue.enqueue("Augusta");
    queue.enqueue("Columbus");

    while (queue.getSize() > 0) {
      System.out.print(queue.dequeue() + " ");
    }
	*/
	  
	// construct queue1 with a different comparator object, say
	// s1, s2 with length of the string
	/*
    queue1.enqueue("ABC");
    queue1.enqueue("A");
    queue1.enqueue("AB");
    queue1.enqueue("ABCDE");
    queue1.enqueue("ABCD");

    System.out.println();
    while (queue1.getSize() > 0) {
      System.out.print(queue1.dequeue() + " ");
    }
    */
  }

  class MyPriorityQueue<E> {
    // implement priority queue
  }
}
