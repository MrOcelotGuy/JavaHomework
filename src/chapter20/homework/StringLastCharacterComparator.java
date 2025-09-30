/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-30
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #9
 * Description: Does Selection Sort with generic objects, this is the comparator class for string
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: none
 */
package chapter20.homework;
import java.util.Comparator;


public class StringLastCharacterComparator
        implements Comparator<String>, java.io.Serializable
{

    @Override
    public int compare(String o1, String o2) {
        if(o1.substring(o1.length()-1).compareTo(o2.substring(o2.length()-1)) < 0)
        {
            return -1;
        }
        else if(o1.substring(o1.length()-1).compareTo(o2.substring(o2.length()-1)) == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
