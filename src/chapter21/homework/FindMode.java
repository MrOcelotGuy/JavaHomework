package chapter21.homework;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-23
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #11
 * Description: This program finds the most common number inputted with help of code I found to sort a map
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: I simply used the same algorithm as in record keeping which you helped me come up with
 * Collaboration: also https://howtodoinjava.com/java/sort/java-sort-map-by-values/
 */
import java.util.*;
import java.util.stream.Collectors;

public class FindMode
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> groups = new TreeMap<>();

        int temp = in.nextInt();
        groups.put(temp, 1);

        while(temp != 0)
        {
            temp = in.nextInt();
            if(!groups.containsKey(temp))
                groups.put(temp, 1);
            else
                groups.replace(temp, groups.get(temp)+1);
        }
        LinkedHashMap<Integer, Integer> sortedMap = groups.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<Integer> thing = new ArrayList<>(sortedMap.keySet());
        System.out.println(thing.getFirst());
        System.out.println(sortedMap);
    }
}
/*
/Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=59298 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework chapter21.homework.FindMode
3
23
4
5
6
4

32
3
4

5
6
7
8
65

3
32
2
34

56

7
88
4
356
33
6
6
365
54363

3
323
46

7
8
5
4
4
23
4
5
46
745
65
4
2
3
4
45
3

0
4
{4=9, 3=6, 5=4, 6=4, 7=3, 2=2, 8=2, 23=2, 32=2, 46=2, 65=2, 0=1, 33=1, 34=1, 45=1, 56=1, 88=1, 323=1, 356=1, 365=1, 745=1, 54363=1}

Process finished with exit code 0
 */