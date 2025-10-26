package chapter22.homework;

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
        Item[] startItems = generateItems(NUMBER_ITEMS, MIN_VALUE, MAX_VALUE, MIN_WEIGHT, MAX_WEIGHT);

//        Item[] startItems = {new Item("Item0", 91, 1),
//                new Item("Item1", 67, 2),
//                new Item("Item2", 97, 4),
//                new Item("Item3", 62, 4),
//                new Item("Item4", 86, 5),
//                new Item("Item5", 74, 1),
//                new Item("Item6", 98, 5),
//                new Item("Item7", 55, 3),
//                new Item("Item8", 60, 2),
//                new Item("Item9", 53, 4)};

        // your work
        GridEntry[][] grid = new GridEntry[KNAPSACK_CAPACITY][NUMBER_ITEMS];

        for(int i = 0; i < KNAPSACK_CAPACITY; i++)
        {
            if(startItems[0].weight <= KNAPSACK_CAPACITY)
            {
                grid[0][i].totalValue = startItems[0].value;
                grid[0][i].items.add(startItems[0]);
            }
        }





    }

     public static Item[] generateItems(int howMany, int lValue, int hValue, int lWeight, int hWeight)
     {
        Item[] results = new Item[howMany];
        for (int i = 0; i < howMany; i++)
        {
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