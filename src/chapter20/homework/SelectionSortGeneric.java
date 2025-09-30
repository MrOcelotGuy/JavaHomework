/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-30
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #9
 * Description: Does Selection Sort with generic objects
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: none
 */
package chapter20.homework;
import chapter13.*;
import chapter20.GeometricObjectComparator;

import java.util.*;

public class SelectionSortGeneric
{
    public static void main(String[] args)
    {
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5), new Circle(5.5), new Rectangle(2.4, 5),
                new Circle(0.5), new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};
        System.out.println("Pre Sort: " + Arrays.toString(list1));
        selectionSort(list1, new GeometricObjectComparator());
        System.out.println("Post Sort: " + Arrays.toString(list1));

        String[] list2 = {"red", "blue", "green", "yellow", "orange", "pink"};
        selectionSort(list2, );
    }

    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator)
    {
        E temp;
        for(int i = 0; i < list.length; i++)
        {
            for(int j = i; j < list.length; j++)
            {
                if(comparator.compare(list[j], list[i]) < 0)
                {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
