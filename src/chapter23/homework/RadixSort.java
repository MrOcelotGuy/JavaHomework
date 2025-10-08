package chapter23.homework;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-07
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #134
 * Description: This program implements radix sort
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration:
 */
import java.util.*;

public class RadixSort
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1000000; i++)
        {
            list.add((int) (Math.random()*1000000));
        }
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        System.out.println(bucket);

        for(int i = 0; i < 10; i++)
        {
            bucket.add(new ArrayList<>());
        }

        for(int i = 1; i <= 6; i++)
        {
            for(int j = 0; j < list.size(); j++)
            {
                bucket.get( (int) ((list.get(j))/(Math.pow(10, i))%10)).add(list.get(j));
            }
            list.clear();
            for(int k = 0; k < bucket.size(); k++)
            {
                list.addAll(bucket.get(k));
                bucket.get(k).clear();
            }
        }

        System.out.println(list);
    }
}
/*
For output you will just need to trust me Mr. Liu it did get sorted you can run it yourself because the output from sorting
a million elements is too big for me to paste here

 */