package midterm1;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(RegularNumber(x));
    }
    public static int RegularNumber(int n)
    {
        TreeSet<Integer> queue = new TreeSet<>();
        queue.add(1);
        int x;
        for(int i = 0; i <= n-2; i++)
        {
            x = queue.pollFirst();
            queue.add(x*2);
            queue.add(x*3);
            queue.add(x*5);
//            System.out.println(i + " " + queue);
        }
//        System.out.println(queue);
        return queue.pollFirst();
    }
}


// i did get 13/13 on this one but fuck my life why did i only get like 50% on multiple choice