package chapter24.homework;

import java.util.Comparator;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-26
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #18
 * Description: I implement priority queue
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: Used the heap class from the source and the assignment
 */

public class Exercise24_06HW {
  public static void main(String[] args)
  {
    new Exercise24_06HW();
  }

  public Exercise24_06HW() {

    // construct queue with a comparator object, say
    // s1, s2 with compareToIgnoreCase
    MyPriorityQueue<String> queue = new MyPriorityQueue<>((s1, s2) -> s1.compareToIgnoreCase(s2));
    queue.enqueue("Macon");
    queue.enqueue("Atlanta");
    queue.enqueue("Savannah");
    queue.enqueue("Augusta");
    queue.enqueue("Columbus");

    while (queue.getSize() > 0) {
      System.out.print(queue.dequeue() + " ");
    }


    // construct queue1 with a different comparator object, say
    // s1, s2 with length of the string
    MyPriorityQueue<String> queue1 = new MyPriorityQueue<>((s1, s2) -> s1.length() - s2.length());
    queue1.enqueue("ABC");
    queue1.enqueue("A");
    queue1.enqueue("AB");
    queue1.enqueue("ABCDE");
    queue1.enqueue("ABCD");

    System.out.println();
    while (queue1.getSize() > 0)
    {
      System.out.print(queue1.dequeue() + " ");
    }

  }

    static class MyPriorityQueue<E extends Comparable>
    {
    // implement priority queue
        private HeapWithComparator<E> heap;

        MyPriorityQueue(Comparator<?super E> comparator)
        {
            heap = new HeapWithComparator<>(comparator);
        }

        public void enqueue(E newObject)
        {
          heap.add(newObject);
        }

        public Object dequeue()
        {
            return heap.remove();
        }

        public int getSize()
        {
            return heap.getSize();
        }

    }

    //Skeleton thingy
    public static class HeapWithComparator<E> {
        private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        private Comparator<? super E> comparator;

        /** Create a heap with the specified comparator */
        public HeapWithComparator()
        {
            this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2); // default
        }

        /** Create a heap with the specified comparator */
        public HeapWithComparator(Comparator<? super E> comparator) {
            this.comparator = comparator;
        }

        /** Add a new object into the heap */
        public void add(E newObject)
        {
            list.add(newObject);
            int currentIndex = list.size() - 1; // The index of the last node

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                // Swap if the current object is greater than its parent
                if (comparator.compare(list.get(currentIndex), (list.get(parentIndex))) < 0)
                {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                }
                else
                    break; // the tree is a heap now

                currentIndex = parentIndex;
            }
        }

        /** Remove the root from the heap */
        public E remove() {
            if (list.isEmpty())
            {
                return null;
            }

            E removedObject = list.getFirst();
            list.set(0, list.getLast());
            list.removeLast();

            int currentIndex = 0;
            while (currentIndex < list.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                // Find the maximum between two children
                if (leftChildIndex >= list.size()) break; // The tree is a heap
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (comparator.compare(list.get(maxIndex), (list.get(rightChildIndex))) > 0) {
                        maxIndex = rightChildIndex;
                    }
                }

                // Swap if the current node is less than the maximum
                if (comparator.compare(list.get(currentIndex), (list.get(maxIndex))) > 0) {
                    E temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                } else
                    break; // The tree is a heap
            }
            return removedObject;
        }

        /** Get the number of nodes in the tree */
        public int getSize() {
            return list.size();
        }
    }
}
// /Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -Djava.library.path=/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=51467 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx-swt.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.web.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.base.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.fxml.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.media.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.swing.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jdk.jsobject.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.controls.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.graphics.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jfx.incubator.input.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jfx.incubator.richtext.jar chapter24.homework.Exercise24_06HW
//Atlanta Augusta Columbus Macon Savannah
//A AB ABC ABCD ABCDE
//Process finished with exit code 0