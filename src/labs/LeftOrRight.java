package labs;

import java.util.*;

public class LeftOrRight
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        double x = in.nextInt();
        double y = in.nextInt();
        double x2 = in.nextInt();
        double y2 = in.nextInt();
        double a = in.nextInt();
        double b = in.nextInt();
        boolean isNegative = (y2-y) < 0;

        if(y == y2)
        {
            if(b == y)
            {
                System.out.println("SAME");
            }
            else if((b < y && isNegative) || b > y && !isNegative)
            {
                System.out.println("LEFT");
            }
            else
            {
                System.out.println("RIGHT");
            }
        }
        else if(x == x2)
        {

            if(a == x)
            {
                System.out.println("SAME");
            }
            else if((a > x && isNegative) || a < x && !isNegative)
            {
                System.out.println("LEFT");
            }
            else
            {
                System.out.println("RIGHT");
            }
        }
        else
        {
            double supposedTo = (y2-y)/(x2-x)*(a-x)+y; //division by 0 problem

            if(b == supposedTo)
            {
                System.out.println("SAME");
            }
            else if((b < supposedTo && isNegative) || b > supposedTo && !isNegative)
            {
                System.out.println("LEFT");
            }
            else
            {
                System.out.println("RIGHT");
            }
        }
    }
}
