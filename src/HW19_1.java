import java.util.ArrayList;

public class HW19_1 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);

      System.out.println(list);
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.println(newList);

    //Added another unit test to ensure the generic templates works with non ints
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");
    stringList.add("d");
    stringList.add("a");
    stringList.add("e");
    stringList.add("a");
    stringList.add("f");

    System.out.println(stringList);
    ArrayList<String> newStringList = removeDuplicates(stringList);
    System.out.println(newStringList);

    ArrayList<Integer> listTwo = new ArrayList<Integer>();

    listTwo.add(17);
    listTwo.add(14);
    listTwo.add(24);
    listTwo.add(14);
    listTwo.add(42);
    listTwo.add(25);
    listTwo.add(24);

    System.out.println(listTwo);
    ArrayList<Integer> newListTwo = removeDuplicates(listTwo);

    System.out.println(newListTwo);
  }

  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
  {
    ArrayList<E> newList = new ArrayList<E>(list);

    for(int i = 0; i < list.size(); i++)
    {
        for(int j = i + 1; j < newList.size(); j++)
        {
            if(list.get(i).equals(newList.get(j)))
            {
                newList.remove(j);
            }
        }
    }

    return newList;
  }
}
