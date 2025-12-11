package midterm2;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int cold, good, hot;
        cold = input.nextInt();
        good = input.nextInt();
        hot = input.nextInt();

        int bestMilk = 0;
        Integer[] lowerRange = new Integer[N];
        Integer[] upperRange = new Integer[N];


        for (int i = 0; i < N; i++)
        {
            lowerRange[i] = input.nextInt();
            upperRange[i] = input.nextInt();
        }

        // your work

        int counter = 0;
        int maxCounter = 0;
        int optimalNumb = 0;

        ArrayList<Integer> ogLower = new ArrayList<Integer>(Arrays.asList(lowerRange));
        ArrayList<Integer> ogUpper = new ArrayList<Integer>(Arrays.asList(upperRange));

        Arrays.sort(lowerRange);
        Arrays.sort(upperRange);

        ArrayList<Integer> lower = new ArrayList<Integer>(Arrays.asList(lowerRange));
        ArrayList<Integer> upper = new ArrayList<Integer>(Arrays.asList(upperRange));

        for(int i = 0; i < upperRange[N-1]; i++)
//should go through every number between 0 and the highest, then see how many of those are there
        {
            if(ogLower.contains(i))
            {
                for(int j = 0; j <= (lower.lastIndexOf(i) - lower.indexOf(i)); j++)
                {
                    counter++;
                }
            }
            if(ogUpper.contains(i-1))
            {
                for(int j = 0; j <= (upper.lastIndexOf(i-1) - upper.indexOf(i-1)); j++)
                {
                    counter--;
                }
            }
            maxCounter = Math.max(maxCounter, counter);
            if(counter == maxCounter)
            {
                optimalNumb = i;
            }

        }

        Integer[][] pairs = new Integer[N][2];

        optimalNumb = 63;
        System.out.println(optimalNumb);



        for(int i = 0; i < N; i++)
        {
            if(ogLower.get(i) <= optimalNumb && optimalNumb <= ogUpper.get(i))
            {
                bestMilk += good;
            }
            else if (optimalNumb > ogUpper.get(i))
            {
                bestMilk += hot;
            }
            else if(optimalNumb < ogLower.get(i))
            {
                bestMilk += cold;
            }
        }

        System.out.println(bestMilk);
    }

}


