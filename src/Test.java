import java.util.*;

public class Test
{
    public static void main(String[] args)
    {

        PriorityQueue<Integer> queue =
                new PriorityQueue<Integer>(
                        Arrays.asList(60, 10, 50, 30, 40, 20));

        for (int i: queue)
            System.out.print(i + " ");
        queue.poll();
        System.out.println();
        for (int i: queue)
            System.out.print(i + " ");
        queue.poll();
        System.out.println();
        for (int i: queue)
            System.out.print(i + " ");
        queue.poll();
        System.out.println();
        for (int i: queue)
            System.out.print(i + " ");
        queue.poll();
        System.out.println();
        for (int i: queue)
            System.out.print(i + " ");
    }
}