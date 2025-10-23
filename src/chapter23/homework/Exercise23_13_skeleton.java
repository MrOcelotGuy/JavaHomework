package chapter23.homework;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-07
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #15
 * Description: This program compares the sorting speed of different sorting algorithms
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: I had help from my dad in making the quicksort and mergesort, and I used the heap class from the textbook source code
 */

import chapter23.Heap;

import java.util.*;

public class Exercise23_13_skeleton
{
	public static void main(String[] args)
    {
        System.out.println("test");
        Comparable[] testingList = {4, 5, 7, 1, 3, 6, 8, 2, 1, 8, 0, 21, 9};
        heapSort(testingList);
        System.out.println(Arrays.toString(testingList));
        System.out.println();
        System.out.println();


		System.out.printf("%12s%12s%12s%12s%12s%12s%12s%12s\n", "Array", "Selection", "Insertion", "Bubble", "Merge",
				"Quick", "Heap", "Radix");
		System.out.printf("%12s%12s%12s%12s%12s%12s%12s%12s\n", "Size", "Sort", "Sort", "Sort", "Sort", "Sort", "Sort",
				"Sort");

		int[] list;
		int[] list1;
		Integer[] list2;
		long startTime;
		long endTime;
		long[][] executionTime = new long[6][7];

		final int BASE = 10000;
		for (int k = 0; k < 6; k++)
        {
			list = new int[(k + 1) * BASE];
			list1 = new int[(k + 1) * BASE];
			list2 = new Integer[(k + 1) * BASE];
			for (int i = 0; i < list.length; i++)
            {
				list[i] = (int) (Math.random() * 100000);
				list1[i] = list[i];
				list2[i] = list[i];
			}

			startTime = System.nanoTime();
			selectionSort(list);
			endTime = System.nanoTime();
			executionTime[k][0] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			insertionSort(list);
			endTime = System.nanoTime();
			executionTime[k][1] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			bubbleSort(list);
			endTime = System.nanoTime();
			executionTime[k][2] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			mergeSort(list);
			endTime = System.nanoTime();
			executionTime[k][3] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			quickSort(list);
			endTime = System.nanoTime();
			executionTime[k][4] = endTime - startTime;

			startTime = System.nanoTime();
			heapSort(list2);
			endTime = System.nanoTime();
			executionTime[k][5] = endTime - startTime;

			startTime = System.nanoTime();
			copyList(list1, list);
			radixSort(list, 5);
			endTime = System.nanoTime();
			executionTime[k][6] = endTime - startTime;
		}

		for (int i = 0; i < 6; i++)
        {
			System.out.printf("%12d", BASE + i * BASE);
			for (int j = 0; j < 7; j++)
            {
                System.out.printf("%12d", executionTime[i][j]);
            }
			System.out.println();
		}
	}

	/** The method for sorting the numbers */
	public static void selectionSort(int[] list)
    {
		// perform selection sort
        //done
        int index = 0;
        for(int i = 0; i < list.length; i++)
        {
            int temp = list[i];
            for(int j = i; j < list.length; j++)
            {
                temp = Math.min(temp, list[j]);
                if(temp == list[j])
                {
                    index = j;
                }
            }
            list[index] = list[i];
            list[i] = temp;

        }

	}

	/** The method for sorting the numbers */
	public static void insertionSort(int[] list)
    {
		// perform insertion sort
        for(int i = 1; i < list.length; i++)
        {
            int temp = list[i];
            int k;
            for(k = i - 1 ; k >= 0 && list[k] > temp; k--)
            {
                list[k+1] = list[k]; //pushes elements to the right
            }
            list[k+1] = temp; //inserts at desired position
        }

	}

	/** The method for sorting the numbers */
	public static void bubbleSort(int[] list) {
		// perform bubble sort
        boolean unFinished = true; //this is to determine if more repetition is needed
        for(int i = 1; i < list.length && unFinished; i++)
        {
            unFinished = false;
            for (int j = 0; j < list.length - i; j++)
            {

                if (list[j] > list[j + 1])
                {
                    int temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    unFinished = true;
                }
            }
        }
	}

	/** The method for sorting the numbers */
	public static void mergeSort(int[] list)
    {
		// perform merge sort
        if(list.length > 2)
        {
            int[] list1 = Arrays.copyOfRange(list, 0, list.length/2);
            int[] list2 = Arrays.copyOfRange(list, list.length/2, list.length);
            mergeSort(list1);
            mergeSort(list2);
            int[] temp = merge(list1, list2);
            System.arraycopy(temp, 0, list, 0, temp.length);
        }
        if(list.length == 2 && list[0] > list[1])
        {
            int temp = list[1];
            list[1] = list[0];
            list[0] = temp;
        }
	}

	private static int[] merge(int[] list1, int[] list2) {
		// merge sort helper
        int[] list = new int[list1.length+list2.length];
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while (current1 < list1.length && current2 < list2.length)
        {
            if (list1[current1] < list2[current2])
            {
                list[current3++] = list1[current1++];
            }
            else
            {
                list[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length)
        {
            list[current3++] = list1[current1++];
        }
        while (current2 < list2.length)
        {
            list[current3++] = list2[current2++];
        }
		return list;
	}

	public static void quickSort(int[] list)
    {
		// perform quick sort
        quickSort(list, 0, list.length-1);
	}

	private static void quickSort(int[] list, int first, int last)
    {
		// quick sort helper
        if(last > first)
        {
            int pivot = partition(list, first, last);
            quickSort(list, first, pivot-1);
            quickSort(list, pivot+1, last);
        }

	}

	/** Partition the array list[first...last] */

    //pivot
    // first +1 last
    // while last more than first
    // while list[first] > pivot swap with last vice versa
    //

	private static int partition(int[] list, int first, int last) {
		// quick sort helper
        int pivot = list[first];
        int low = first + 1;
        int high = last; //preserve original variable
        while(high > low)
        {
            while(low <= high && list[low] <= pivot)
            {
                low++;
            }
            while(low <= high && list[high] > pivot)
            {
                high--;
            }
            if(high>low)
            {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while(high > first && list[high] >= pivot)
        {
            high --;
        }
        if(pivot > list[high])
        {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else
		    return first;
	}

	public static void heapSort(Comparable[] list) {
		// perform heap sort
        Heap heap = new Heap();
        for(Comparable x: list)
        {
            heap.add(x);
        }

        for(int i = heap.getSize()-1; i >= 0; i--)
        {
            list[i] = (Comparable) heap.remove();
        }
	}

	/**
	 * Sort the int array list. numberOfDigits is the number of digits in the
	 * largest number in the array
	 */
	public static void radixSort(int[] list, int numberOfDigits)
    {
		// perform radix sort
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int i = 0; i < 10; i++)
        {
            buckets[i] = new ArrayList<>();
        }

        for(int i = 0; i < numberOfDigits; i++)
        {
            for(int j = 0; j < list.length; j++)
            {
                buckets[getKey(list[j], i)].add(list[j]);
            }
            ArrayList<Integer> tempList = new ArrayList<>();
            for(int k = 0; k < 10; k++)
            {
                tempList.addAll(buckets[k]);
                buckets[k].clear();
            }
            for(int j = 0; j < tempList.size(); j++)
            {
                list[j] = tempList.get(j);
            }
        }

	}

	/**
	 * Return the digit at the specified position. The last digit's position is 0.
	 */
	public static int getKey(int number, int position)
    {
		// radix sort helper
		return (int) (number/Math.pow(10, position)%10);
	}

	public static void copyList(int[] list1, int[] list) {
		for (int i = 0; i < list1.length; i++)
			list[i] = list1[i];
	}
}
