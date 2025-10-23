package chapter24.homework;

import java.util.Iterator;

public class Exercise24_13HW {
  public static void main(String[] args) {
    Iterator<Integer> iterator = new FibonacciIterator(1000000);
// print out all Fibonacci numbers before 1000000
  }
  
  static class FibonacciIterator implements java.util.Iterator<Integer> {
    private int limit;
    
    public FibonacciIterator(int limit) {
      this.limit = limit;
    }
    
    @Override 
    public Integer next() {
      return 0;
    }
    
    @Override 
    public boolean hasNext() {
      return false;
    }
    
    @Override 
    public void remove() {
      throw new UnsupportedOperationException
        ("Method not supported");
    }
  }
  
}
