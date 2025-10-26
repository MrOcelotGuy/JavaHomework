package chapter24.homework;

import java.util.Iterator;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-10-26
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #19
 * Description: I use an iterator to generate fibonacci numbers
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: You helped me out with this in office hours
 */

public class Exercise24_13HW {
  public static void main(String[] args) {
    Iterator<Integer> iterator = new FibonacciIterator(1000000);
// print out all Fibonacci numbers before 1000000
      while(iterator.hasNext())
      {
          System.out.println(iterator.next());
      }
  }
  
  static class FibonacciIterator implements java.util.Iterator<Integer>
  {
    private int limit;
    private int f0 = 0;
    private int f1 = 1;
    
    public FibonacciIterator(int limit)
    {
        this.limit = limit;
    }
    
    @Override 
    public Integer next()
    {
        int temp = f0;
        f0 = f1;
        f1 = f0 + temp;
        return f0;
    }
    
    @Override 
    public boolean hasNext()
    {
        if(f1 > limit)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    @Override 
    public void remove()
    {
        throw new UnsupportedOperationException ("Method not supported");
    }
  }
  
}
// /Users/diegomeneses/Library/Java/JavaVirtualMachines/openjdk-24.0.2+12-54/Contents/Home/bin/java -Djava.library.path=/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=51457 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/diegomeneses/Projects/Java School Project/JavaHomework/out/production/Java Homework:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx-swt.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.web.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.base.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.fxml.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.media.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.swing.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jdk.jsobject.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.controls.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/javafx.graphics.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jfx.incubator.input.jar:/Users/diegomeneses/Projects/libraries/javafx-sdk-25.0.1/lib/jfx.incubator.richtext.jar chapter24.homework.Exercise24_13HW
//1
//1
//2
//3
//5
//8
//13
//21
//34
//55
//89
//144
//233
//377
//610
//987
//1597
//2584
//4181
//6765
//10946
//17711
//28657
//46368
//75025
//121393
//196418
//317811
//514229
//832040
//
//Process finished with exit code 0