package labs;

import java.util.*;
public class bovineGenomics
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        int width = in.nextInt();

        in.nextLine();

        int tally = 0;

        ArrayList<String> spotted = new ArrayList<>();
        ArrayList<String> plain = new ArrayList<>();

        for(int i = 0; i < height; i++)
        {
            spotted.add(in.nextLine());
        }
        for(int i = 0; i < height; i++)
        {
            plain.add(in.nextLine());
        }

        Set<String> spotSet = new HashSet<>();
        Set<String> plainSet = new HashSet<>();

        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                spotSet.add(spotted.get(j).substring(i, i+1));
                plainSet.add(plain.get(j).substring(i,i+1));
            }
            Set<String> intersect = new HashSet<>(spotSet);
            intersect.removeAll(plainSet);
            if(intersect.equals(spotSet))
            {
                tally++;
            }
            spotSet.clear();
            plainSet.clear();
        }

        System.out.println(tally);
    }
}
