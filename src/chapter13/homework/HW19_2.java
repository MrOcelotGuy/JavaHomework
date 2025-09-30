package chapter13.homework;

/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-09
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #2
 * Description: Generic method to find the maximum
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: none
 */

public class HW19_2 {
  public static void main(String[] args)
  {
    Integer[][] numbers = { {1, 2, 3}, {4, 4, 6}};

    String[][] words = { {"a", "b", "c"}, {"d", "e", "f"}};

    Boolean[][] booleans = { {true, false, true}, {true, false, true}};

    Integer[][] numbers2 = { {1, 2, 3}, {4, 4, 0}};

    System.out.println(max(numbers));
    System.out.println(max(words));
    System.out.println(max(booleans));
    System.out.println(max(numbers2));
  }

  public static <E extends Comparable<E>> E max(E[][] arr)
  {
      E max = arr[0][0];
      for(int i = 1; i < arr.length; i++)
      {
          for(int j = 0; j < arr[i].length; j++)
          {
              if(arr[i][j].compareTo(max) > 0)
              {
                max = arr[i][j];
              }
          }
      }
      return max;
  }

}
