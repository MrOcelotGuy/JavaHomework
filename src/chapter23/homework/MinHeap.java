package chapter23.homework;
import java.util.*;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-07
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #13
 * Description: This program implements a min-heap
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: I modified the heap class from the textbook
 */

public class MinHeap<E extends Comparable> {
    private ArrayList<E> heap = new ArrayList<>();


    public MinHeap()
    {

    }

    public MinHeap(E[] object)
    {
        heap.addAll(Arrays.asList(object));
    }

    public void add(E newObject)
    {
        heap.add(newObject); // Append to the heap
        int currentIndex = heap.size() - 1; // The index of the last node

        while (currentIndex > 0)
        {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0)  //pretty much all that needed to be changed from the heap class
            {
                E temp = heap.get(currentIndex);
                heap.set(currentIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

            }
            else
            {
                break; // The tree is a heap now
            }

            currentIndex = parentIndex;
        }
    }

    public E remove()
    {
        if (heap.size() == 0) return null;


        E removedObject = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int currentIndex = 0;
        while (currentIndex < heap.size())
        {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= heap.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < heap.size()) {
                if (heap.get(maxIndex).compareTo(heap.get(rightChildIndex)) > 0) //and this
                {
                    maxIndex = rightChildIndex;
                }
            }
            // Swap if the current node is less than the maximum
            if (heap.get(currentIndex).compareTo(heap.get(maxIndex)) > 0) //also change this
            {
                E temp = heap.get(maxIndex);
                heap.set(maxIndex, heap.get(currentIndex));
                heap.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
            {
                break;
            }
        }
        return removedObject;
    }

    public int getSize()
    {
        return heap.size();
    }

}
