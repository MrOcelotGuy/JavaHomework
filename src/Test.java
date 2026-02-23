import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        printConvert(0x12345678);
        System.out.println();
        System.out.println("00010010001101000101011001111000".equals("00010010001101000101011001111000"));
    }
    public static void printConvert(long n)
    {
        for(long i = 31; i >= 0; i--)
        {
            System.out.print( (n & ((long)Math.pow(2, i) ) )>= 1 ? 1 : 0);

        }
    }

}