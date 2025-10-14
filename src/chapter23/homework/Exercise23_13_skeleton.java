package chapter23.homework;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-07
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #15
 * Description: This program compares the sorting speed of different sorting algorithms
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration:
 */

public class Exercise23_13_skeleton
{
	public static void main(String[] args)
    {
//        int[] testingList = {4, 5, 7, 1, 3, 6, 8, 2, 1, 8, 0, 21, 4};
//        bubbleSort(testingList);
//        for(int x: testingList)
//        {
//            System.out.print(x + ", ");
//        }
//        System.out.println();
//        System.out.println();


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
	public static void mergeSort(int[] list) {
		// perform merge sort

	}

	private static int[] merge(int[] list1, int[] list2) {
		// merge sort helper
		return null;
	}

	public static void quickSort(int[] list) {
		// perform quick sort
	}

	private static void quickSort(int[] list, int first, int last) {
		// quick sort helper
	}

	/** Partition the array list[first..last] */
	private static int partition(int[] list, int first, int last) {
		// quick sort helper
		return 0;
	}

	public static void heapSort(Comparable[] list) {
		// perform heap sort
        

	}

	/**
	 * Sort the int array list. numberOfDigits is the number of digits in the
	 * largest number in the array
	 */
	public static void radixSort(int[] list, int numberOfDigits)
    {
		// perform radix sort

	}

	/**
	 * Return the digit at the specified position. The last digit's position is 0.
	 */
	public static int getKey(int number, int position) {
		// radix sort helper
		return 0;
	}

	public static void copyList(int[] list1, int[] list) {
		for (int i = 0; i < list1.length; i++)
			list[i] = list1[i];
	}
}
