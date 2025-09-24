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
            notes.add(in.nextInt());
        }
        int c = in.nextInt();
        ArrayList<Integer> chord = new ArrayList<>();
        for(int i = 0; i < c; i++)
        {
            chord.add(in.nextInt());
        }
        chord.sort(null);

        ArrayList<Integer> chord2 = new ArrayList<>();

        ArrayList<Integer> problemPlaces = new ArrayList<>();

        boolean isEqual = false;

        if(c > 1)
        {
            for (int i = 0; i <= notes.size() - c; i++) {
                for (int j = i; j < c + i; j++) {
                    chord2.add(notes.get(j));
                }
                chord2.sort(null);
                for (int k = 1; k < c; k++) {
                    if ((chord.get(k) - chord.get(k - 1)) != (chord2.get(k) - chord2.get(k - 1))) {
                        isEqual = false;
                        break;
                    } else {
                        isEqual = true;
                    }
                }
                if (isEqual) {
                    problemPlaces.add(i + 1);
                }
                chord2.clear();
            }
        }
        else
        {
            for(int i = 0; i < notes.size(); i++)
            {
                problemPlaces.add(i+1);
            }
        }


        if(problemPlaces.isEmpty())
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(problemPlaces.size());
            for (Integer problemPlace : problemPlaces)
            {
                System.out.println(problemPlace);
            }
        }


    }
}
