package chapter22.homework;

public class Item {
    String name;
    int value;
    int weight;

    public Item(String s, int v, int w) {
        name = s;
        value = v;
        weight = w;
    }

    @Override
    public String toString() {
        return name + ":" + value + "|" + weight;
    }
}