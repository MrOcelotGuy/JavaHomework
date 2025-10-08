package chapter21.homework;

import java.util.*;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-23
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #10
 * Description: This program operates on two different linkedHashSets to show I know how
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: You helped me to understand what had to be done Mr. Liu.
 */

public class HashOperate
{
    public static void main(String[] args)
    {
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();


        firstSet.add("George");
        firstSet.add("Jim");
        firstSet.add("John");
        firstSet.add("Blake");
        firstSet.add("Kevin");
        firstSet.add("Michael");

        secondSet.add("George");
        secondSet.add("Katie");
        secondSet.add("Kevin");
        secondSet.add("Michelle");
        secondSet.add("Ryan");

        LinkedHashSet<String> firstSetClone1 = (LinkedHashSet<String>) firstSet.clone () ;
        LinkedHashSet<String> firstSetClone2 = (LinkedHashSet<String>) firstSet.clone () ;
        LinkedHashSet<String> firstSetClone3 = (LinkedHashSet<String>) firstSet.clone () ;

        firstSetClone1.addAll(secondSet);
        firstSetClone2.removeAll(secondSet);
        firstSetClone3.retainAll(secondSet);

        System.out.println("Union: " + firstSetClone1);
        System.out.println("Difference: " + firstSetClone2);
        System.out.println("Intersection: " + firstSetClone3);

    }
}
/*
/Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=53937 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework chapter21.homework.HashOperate
Union: [George, Jim, John, Blake, Kevin, Michael, Katie, Michelle, Ryan]
Difference: [Jim, John, Blake, Michael]
Intersection: [George, Kevin]

Process finished with exit code 0

 */