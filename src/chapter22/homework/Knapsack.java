package chapter22.homework;

import java.util.*;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-07
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #12
 * Description: This program finds the most efficient way to steal and stuff into a knapsack
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration:
 */

public class Knapsack {

    public static void main(String[] args) {
        final int NUMBER_ITEMS = 10;
        final int MIN_WEIGHT = 1;
        final int MAX_WEIGHT = 5;
        final int MIN_VALUE = 50;
        final int MAX_VALUE = 100;
        final int KNAPSACK_CAPACITY = 20;
        Item[] items = generateItems(NUMBER_ITEMS, MIN_VALUE, MAX_VALUE, MIN_WEIGHT, MAX_WEIGHT);

        // your work

    }

     public static Item[] generateItems(int howMany, int lValue, int hValue, int lWeight, int hWeight) {
        Item[] results = new Item[howMany];
        for (int i = 0; i < howMany; i++) {
            int value = (int) (Math.random() * (hValue - lValue + 1)) + lValue;
            int weight = (int) (Math.random() * (hWeight - lWeight + 1)) + lWeight;
            results[i] = new Item("Item" + i, value, weight);
        }
        return results;
    }


//For testing purposes, modify generateItems such that the items are:
//
//Item0:91|1
//Item1:67|2
//Item2:97|4
//Item3:62|4
//Item4:86|5
//Item5:74|1
//Item6:98|5
//Item7:55|3
//Item8:60|2
//Item9:53|4

}