package chapter22.homework;
import java.util.*;

public class GridEntry
{
    public ArrayList<Item> items = new ArrayList<>();
    public int totalValue;

    public String toString() {
        String output = "Total Value:$" + totalValue + " ";
        for (Item i: items) {
            output += i + " ";
        }
        return output;
    }
}