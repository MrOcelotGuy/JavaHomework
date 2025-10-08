package chapter23;

import chapter23.homework.MinHeap;

import java.util.*;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-07
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #13
 * Description: This program implements a min-heap
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: I modified the heap class from the textbook
 */

public class TestHeap
{
    public static void main(String[] args)
    {
        MinHeap<Integer> minimalHeap = new MinHeap<>();
        for(int i = 0; i < 15; i++)
            minimalHeap.add( (int) (Math.random()*100));

        while(minimalHeap.getSize() != 0)
        {
            System.out.println(minimalHeap.remove());
        }

    }
}
/*
1st time
/Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=63464 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework chapter23.TestHeap
0
1
7
17
30
32
33
34
44
54
57
77
80
81
89

Process finished with exit code 0

2nd time
/Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=63499 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework chapter23.TestHeap
2
6
35
39
49
51
53
56
56
67
68
78
81
86
92

Process finished with exit code 0

3rd time
/Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=63505 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework chapter23.TestHeap
3
10
14
14
16
17
24
31
38
41
48
53
59
67
98

Process finished with exit code 0


 */
