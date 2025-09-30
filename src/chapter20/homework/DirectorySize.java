package chapter20.homework;

import java.io.*;
import java.util.*;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-27
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #8
 * Description: finds the directory size without recursion
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: none
 */

public class DirectorySize
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a directory or file");
        String directory = in.nextLine();
        System.out.println(getSize(new File(directory)) + " bytes");

    }
    public static long getSize(File directory)
    {
        Queue<File> theQueue = new PriorityQueue<>();
        long size = 0;
        theQueue.add(directory);
        File file = theQueue.poll();
        System.out.println(file);
        do
        {
            if(file.isFile())
            {
                size += file.length();
            }
            else
            {
                File[] fileList = file.listFiles();
                theQueue.addAll(Arrays.asList(fileList));
            }
            file = theQueue.poll();
        }while(!theQueue.isEmpty());
        return size;
    }
}
/*
/Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=57916 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework chapter20.homework.DirectorySize
Enter a directory or file
/Users/diegomeneses/Projects
/Users/diegomeneses/Projects
2682137 bytes

Process finished with exit code 0
 */
