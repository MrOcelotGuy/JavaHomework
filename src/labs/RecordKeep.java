package labs;

import java.util.*;

//collaboration https://stackoverflow.com/questions/7999192/creating-an-array-of-sets-in-java

public class RecordKeep
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int hours = in.nextInt();
        in.nextLine();

        Map<String, Integer> groups = new TreeMap<>();

        String temp;
        String[] words;

        for(int i = 0; i < hours; i++)
        {
            temp = in.nextLine();
            words = temp.split(" ");
            Arrays.sort(words);
            String wordString = Arrays.toString(words);
            if(!groups.containsKey(wordString))
                groups.put(wordString, 1);
            else
                groups.replace(wordString, groups.get(wordString)+1);
        }

       List<Integer> thing = new ArrayList<>(groups.values());
        Collections.sort(thing);
        System.out.println(thing.getLast());

    }
}