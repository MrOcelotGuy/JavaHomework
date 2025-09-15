/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-09
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #5
 * Description: The program uses recursion and iteration in order to get the binomial coefficient of a pair of numbers
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration: Intellisense suggested I cast the iterative one due to lossy conversion, and that fixed my
 * error of it returning 0
 *
 * made a typo in the class only just noticed
 */

public class bionomialRecursive
{
    //implement the binomial coefficient recursively as described in instructions
    public static int cr(int n, int k)
    {
        if(0 < k && k < n)
            return cr(n-1, k-1) + cr(n-1, k);  //ironically implementing the recursive one was easier
        else if(n<k)
            return 0; //edge case if k is actually larger
        else
            return 1;
    }

    //implement the binomial coefficient iteratively as described in instructions
    public static int ci(int n, int k)
    {
        double result = 1;
        for(int i = 0; i < k; i++)
        {
            result *= (((double)n - i) /(1+i));
        }
        return (int)(result+0.5);
    }

    public static void main(String[] args)
    {
        //testing it
        System.out.println(cr(100,6));
        System.out.println(ci(100,6));

        System.out.println(cr(32,6));
        System.out.println(ci(32,6));

        System.out.println(cr(2,6));
        System.out.println(ci(2,6));

        System.out.println(cr(2,0));
        System.out.println(ci(2,0));
    }
}
//1192052400
//1192052400
//906192
//906192
//0
//0
//
//Process finished with exit code 0