package finalExam;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();
        int T = sc.nextInt();

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // define the adjacency list, or list of vertices
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        int[] parents = new int[N];
        Arrays.fill(parents, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);

        // TODO: BFS initialization

        int tempNum;
        // TODO: BFS loop

        Set<Integer> tSet = new HashSet<>();

        while(!q.isEmpty())
        {
            tempNum = q.poll();

            for(int x : edges.get(tempNum))
            {
                if(!tSet.contains(x) && parents[x] != 0)
                {
                    q.offer(x);
                    parents[x] = tempNum;
                }
            }
            tSet.add(tempNum);
            if(parents[T] != -1)
            {
                break;
            }
        }

        int test = parents[T];
        int counter = 0;
        while(test != -1)
        {
            test = parents[test];
            counter ++;
        }


        System.out.println(counter);
    }
}