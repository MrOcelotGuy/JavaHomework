import java.util.*;

public class mooSick
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> notes = new ArrayList<Integer>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            notes.addLast(in.nextInt());
        }
        int c = in.nextInt();
        SortedSet<Integer> chord = new TreeSet<Integer>();
        for(int i = 0; i < c; i++)
        {
            chord.add(in.nextInt());
        }

        SortedSet<Integer> chord2 = new TreeSet<>();

        for(int i = 0; i < notes.size(); i++)
        {

            chord.equals(chord2);
        }

        System.out.println(chord);


    }
}
