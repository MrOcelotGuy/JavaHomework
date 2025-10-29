package chapter22.homework;

/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-26
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #12
 * Description: This program finds the most efficient way to steal and stuff into a knapsack
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: Mr. Liu you greatly helped me during office hours with understanding the assignment as a whole now I understand dynamic programming
 */

public class Knapsack {

    public static void main(String[] args) {
        final int NUMBER_ITEMS = 10;
        final int MIN_WEIGHT = 1;
        final int MAX_WEIGHT = 5;
        final int MIN_VALUE = 50;
        final int MAX_VALUE = 100;
        final int KNAPSACK_CAPACITY = 20;
//        Item[] startItems = generateItems(NUMBER_ITEMS, MIN_VALUE, MAX_VALUE, MIN_WEIGHT, MAX_WEIGHT);

        Item[] startItems = {new Item("Item0", 91, 1),
                new Item("Item1", 67, 2),
                new Item("Item2", 97, 4),
                new Item("Item3", 62, 4),
                new Item("Item4", 86, 5),
                new Item("Item5", 74, 1),
                new Item("Item6", 98, 5),
                new Item("Item7", 55, 3),
                new Item("Item8", 60, 2),
                new Item("Item9", 53, 4)};

        // your work
        //leaving comments of what I understand to ensure i grasp the core concept

        GridEntry[][] grid = new GridEntry[NUMBER_ITEMS][KNAPSACK_CAPACITY+1];
        for(int i = 0; i < NUMBER_ITEMS; i++)
        {
            for(int j = 0; j < KNAPSACK_CAPACITY+1; j++)
            {
                grid[i][j] = new GridEntry();
            }
        }

        for(int i = 0; i <= KNAPSACK_CAPACITY; i++)
        {
            if(startItems[0].weight <= i) //this part fills out the first row
            {
                grid[0][i].totalValue = startItems[0].value; //fills in values
                grid[0][i].items.add(startItems[0]); //adds the first item to the items list
            }
        }

        for(int itemRow = 1; itemRow < NUMBER_ITEMS; itemRow++) //this part fills out the rest
        {
            for(int capacityNum = 1; capacityNum <= KNAPSACK_CAPACITY; capacityNum++) //itemRow is x axis and capacityNum is y axis
            {
                if(capacityNum >= startItems[itemRow].weight) //This compares to see if the current weight capacity is at least the weight of the current item
                { //by that of course I mean it sees if the current item fits
                    int value = startItems[itemRow].value + grid[itemRow - 1][capacityNum - startItems[itemRow].weight].totalValue;
                    if(value > grid[itemRow -1][capacityNum].totalValue)
                    {
                        grid[itemRow][capacityNum].totalValue = value;
                        grid[itemRow][capacityNum].items.addAll(grid[itemRow -1][capacityNum-startItems[itemRow].weight].items);
                        grid[itemRow][capacityNum].items.add(startItems[itemRow]);
                    }
                    else
                    {
                        grid[itemRow][capacityNum].items = grid[itemRow -1][capacityNum].items;
                        grid[itemRow][capacityNum].totalValue = grid[itemRow -1][capacityNum].totalValue;
                    }
                }
                else //If the current item doesn't fit it takes from above
                {
                    grid[itemRow][capacityNum].items = grid[itemRow -1][capacityNum].items;
                    grid[itemRow][capacityNum].totalValue = grid[itemRow -1][capacityNum].totalValue;
                }
            }


        }

        for(int i = 0; i < NUMBER_ITEMS; i++)
        {
            for(int j = 1; j <= KNAPSACK_CAPACITY; j++)
            {
                System.out.print("grid [" + i + "][" + j + "]=" + grid[i][j] + "\t");
            }
            System.out.println();
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
//Output:

// /Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -Djava.library.path=/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=55022 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx-swt.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.web.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.base.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.fxml.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.media.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.swing.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jdk.jsobject.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.controls.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.graphics.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jfx.incubator.input.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jfx.incubator.richtext.jar chapter22.homework.Knapsack
//grid [0][1]=Total Value:$91 Item0:91|1 	grid [0][2]=Total Value:$91 Item0:91|1 	grid [0][3]=Total Value:$91 Item0:91|1 	grid [0][4]=Total Value:$91 Item0:91|1 	grid [0][5]=Total Value:$91 Item0:91|1 	grid [0][6]=Total Value:$91 Item0:91|1 	grid [0][7]=Total Value:$91 Item0:91|1 	grid [0][8]=Total Value:$91 Item0:91|1 	grid [0][9]=Total Value:$91 Item0:91|1 	grid [0][10]=Total Value:$91 Item0:91|1 	grid [0][11]=Total Value:$91 Item0:91|1 	grid [0][12]=Total Value:$91 Item0:91|1 	grid [0][13]=Total Value:$91 Item0:91|1 	grid [0][14]=Total Value:$91 Item0:91|1 	grid [0][15]=Total Value:$91 Item0:91|1 	grid [0][16]=Total Value:$91 Item0:91|1 	grid [0][17]=Total Value:$91 Item0:91|1 	grid [0][18]=Total Value:$91 Item0:91|1 	grid [0][19]=Total Value:$91 Item0:91|1 	grid [0][20]=Total Value:$91 Item0:91|1
//grid [1][1]=Total Value:$91 Item0:91|1 	grid [1][2]=Total Value:$91 Item0:91|1 	grid [1][3]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][4]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][5]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][6]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][7]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][8]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][9]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][10]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][11]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][12]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][13]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][14]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][15]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][16]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][17]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][18]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][19]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [1][20]=Total Value:$158 Item0:91|1 Item1:67|2
//grid [2][1]=Total Value:$91 Item0:91|1 	grid [2][2]=Total Value:$91 Item0:91|1 	grid [2][3]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [2][4]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [2][5]=Total Value:$188 Item0:91|1 Item2:97|4 	grid [2][6]=Total Value:$188 Item0:91|1 Item2:97|4 	grid [2][7]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][8]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][9]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][10]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][11]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][12]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][13]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][14]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][15]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][16]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][17]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][18]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][19]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [2][20]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4
//grid [3][1]=Total Value:$91 Item0:91|1 	grid [3][2]=Total Value:$91 Item0:91|1 	grid [3][3]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [3][4]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [3][5]=Total Value:$188 Item0:91|1 Item2:97|4 	grid [3][6]=Total Value:$188 Item0:91|1 Item2:97|4 	grid [3][7]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [3][8]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [3][9]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [3][10]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [3][11]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][12]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][13]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][14]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][15]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][16]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][17]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][18]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][19]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [3][20]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4
//grid [4][1]=Total Value:$91 Item0:91|1 	grid [4][2]=Total Value:$91 Item0:91|1 	grid [4][3]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [4][4]=Total Value:$158 Item0:91|1 Item1:67|2 	grid [4][5]=Total Value:$188 Item0:91|1 Item2:97|4 	grid [4][6]=Total Value:$188 Item0:91|1 Item2:97|4 	grid [4][7]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [4][8]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [4][9]=Total Value:$255 Item0:91|1 Item1:67|2 Item2:97|4 	grid [4][10]=Total Value:$274 Item0:91|1 Item2:97|4 Item4:86|5 	grid [4][11]=Total Value:$317 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 	grid [4][12]=Total Value:$341 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 	grid [4][13]=Total Value:$341 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 	grid [4][14]=Total Value:$341 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 	grid [4][15]=Total Value:$341 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 	grid [4][16]=Total Value:$403 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 	grid [4][17]=Total Value:$403 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 	grid [4][18]=Total Value:$403 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 	grid [4][19]=Total Value:$403 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 	grid [4][20]=Total Value:$403 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5
//grid [5][1]=Total Value:$91 Item0:91|1 	grid [5][2]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [5][3]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [5][4]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [5][5]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [5][6]=Total Value:$262 Item0:91|1 Item2:97|4 Item5:74|1 	grid [5][7]=Total Value:$262 Item0:91|1 Item2:97|4 Item5:74|1 	grid [5][8]=Total Value:$329 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 	grid [5][9]=Total Value:$329 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 	grid [5][10]=Total Value:$329 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 	grid [5][11]=Total Value:$348 Item0:91|1 Item2:97|4 Item4:86|5 Item5:74|1 	grid [5][12]=Total Value:$391 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 	grid [5][13]=Total Value:$415 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 	grid [5][14]=Total Value:$415 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 	grid [5][15]=Total Value:$415 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 	grid [5][16]=Total Value:$415 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 	grid [5][17]=Total Value:$477 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 Item5:74|1 	grid [5][18]=Total Value:$477 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 Item5:74|1 	grid [5][19]=Total Value:$477 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 Item5:74|1 	grid [5][20]=Total Value:$477 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item4:86|5 Item5:74|1
//grid [6][1]=Total Value:$91 Item0:91|1 	grid [6][2]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [6][3]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [6][4]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [6][5]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [6][6]=Total Value:$262 Item0:91|1 Item2:97|4 Item5:74|1 	grid [6][7]=Total Value:$263 Item0:91|1 Item5:74|1 Item6:98|5 	grid [6][8]=Total Value:$329 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 	grid [6][9]=Total Value:$330 Item0:91|1 Item1:67|2 Item5:74|1 Item6:98|5 	grid [6][10]=Total Value:$330 Item0:91|1 Item1:67|2 Item5:74|1 Item6:98|5 	grid [6][11]=Total Value:$360 Item0:91|1 Item2:97|4 Item5:74|1 Item6:98|5 	grid [6][12]=Total Value:$391 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 	grid [6][13]=Total Value:$427 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 	grid [6][14]=Total Value:$427 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 	grid [6][15]=Total Value:$427 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 	grid [6][16]=Total Value:$446 Item0:91|1 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5 	grid [6][17]=Total Value:$489 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item6:98|5 	grid [6][18]=Total Value:$513 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5 	grid [6][19]=Total Value:$513 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5 	grid [6][20]=Total Value:$513 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5
//grid [7][1]=Total Value:$91 Item0:91|1 	grid [7][2]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [7][3]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [7][4]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [7][5]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [7][6]=Total Value:$262 Item0:91|1 Item2:97|4 Item5:74|1 	grid [7][7]=Total Value:$287 Item0:91|1 Item1:67|2 Item5:74|1 Item7:55|3 	grid [7][8]=Total Value:$329 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 	grid [7][9]=Total Value:$330 Item0:91|1 Item1:67|2 Item5:74|1 Item6:98|5 	grid [7][10]=Total Value:$330 Item0:91|1 Item1:67|2 Item5:74|1 Item6:98|5 	grid [7][11]=Total Value:$384 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item7:55|3 	grid [7][12]=Total Value:$391 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 	grid [7][13]=Total Value:$427 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 	grid [7][14]=Total Value:$427 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 	grid [7][15]=Total Value:$446 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item7:55|3 	grid [7][16]=Total Value:$482 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 Item7:55|3 	grid [7][17]=Total Value:$489 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item6:98|5 	grid [7][18]=Total Value:$513 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5 	grid [7][19]=Total Value:$513 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5 	grid [7][20]=Total Value:$544 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item6:98|5 Item7:55|3
//grid [8][1]=Total Value:$91 Item0:91|1 	grid [8][2]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [8][3]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [8][4]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [8][5]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [8][6]=Total Value:$292 Item0:91|1 Item1:67|2 Item5:74|1 Item8:60|2 	grid [8][7]=Total Value:$292 Item0:91|1 Item1:67|2 Item5:74|1 Item8:60|2 	grid [8][8]=Total Value:$329 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 	grid [8][9]=Total Value:$347 Item0:91|1 Item1:67|2 Item5:74|1 Item7:55|3 Item8:60|2 	grid [8][10]=Total Value:$389 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item8:60|2 	grid [8][11]=Total Value:$390 Item0:91|1 Item1:67|2 Item5:74|1 Item6:98|5 Item8:60|2 	grid [8][12]=Total Value:$391 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 	grid [8][13]=Total Value:$444 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item7:55|3 Item8:60|2 	grid [8][14]=Total Value:$451 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item8:60|2 	grid [8][15]=Total Value:$487 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 Item8:60|2 	grid [8][16]=Total Value:$487 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 Item8:60|2 	grid [8][17]=Total Value:$506 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item7:55|3 Item8:60|2 	grid [8][18]=Total Value:$542 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 Item7:55|3 Item8:60|2 	grid [8][19]=Total Value:$549 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item6:98|5 Item8:60|2 	grid [8][20]=Total Value:$573 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5 Item8:60|2
//grid [9][1]=Total Value:$91 Item0:91|1 	grid [9][2]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [9][3]=Total Value:$165 Item0:91|1 Item5:74|1 	grid [9][4]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [9][5]=Total Value:$232 Item0:91|1 Item1:67|2 Item5:74|1 	grid [9][6]=Total Value:$292 Item0:91|1 Item1:67|2 Item5:74|1 Item8:60|2 	grid [9][7]=Total Value:$292 Item0:91|1 Item1:67|2 Item5:74|1 Item8:60|2 	grid [9][8]=Total Value:$329 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 	grid [9][9]=Total Value:$347 Item0:91|1 Item1:67|2 Item5:74|1 Item7:55|3 Item8:60|2 	grid [9][10]=Total Value:$389 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item8:60|2 	grid [9][11]=Total Value:$390 Item0:91|1 Item1:67|2 Item5:74|1 Item6:98|5 Item8:60|2 	grid [9][12]=Total Value:$391 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 	grid [9][13]=Total Value:$444 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item7:55|3 Item8:60|2 	grid [9][14]=Total Value:$451 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item8:60|2 	grid [9][15]=Total Value:$487 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 Item8:60|2 	grid [9][16]=Total Value:$487 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 Item8:60|2 	grid [9][17]=Total Value:$506 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item7:55|3 Item8:60|2 	grid [9][18]=Total Value:$542 Item0:91|1 Item1:67|2 Item2:97|4 Item5:74|1 Item6:98|5 Item7:55|3 Item8:60|2 	grid [9][19]=Total Value:$549 Item0:91|1 Item1:67|2 Item2:97|4 Item3:62|4 Item5:74|1 Item6:98|5 Item8:60|2 	grid [9][20]=Total Value:$573 Item0:91|1 Item1:67|2 Item2:97|4 Item4:86|5 Item5:74|1 Item6:98|5 Item8:60|2
//
//Process finished with exit code 0