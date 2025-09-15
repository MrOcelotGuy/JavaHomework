import java.util.*;
/*
 * Author: Diego Arturo Meneses Prieto
 * Date: 2025-09-09
 * Course: CIST-004B1 - Advanced Java Data Structures
 * Homework: #4
 * Description: The program uses a lambda expression and an interface in order to calculate factorials
 * Honor Code: I affirm that this program is entirely my own work.
 * Collaboration:
 */

public class sineCosine
{

    public static double sin(double x)
    {
        if(-0.005 < x && x < 0.005)
            return x- (x*x*x)/6.0;
        else
            return 2*sin(x/2)*cos(x/2); //rewrote double angle formula to work with sin(x) instead of sin(2x)
    }
    public static double cos(double x)
    {
        if(-0.005 < x && x < 0.005)
            return 1- (x*x)/2;
        else
            return 1-2*sin(x/2)*sin(x/2); //rewrote double angle formula to work with sin(x) instead of sin(2x)
    }
    public static void main(String[] args)
    {
        for(double i = 0.0; i <= 1.0; i += 0.1) {
            System.out.println("\n my sine  " + sin(i));
            System.out.println("real sine " + Math.sin(i) + "\n");
            System.out.println("my cosine   " + cos(i));
            System.out.println("real cosine " + cos(i));
        }
    }
}

// my sine  0.0
//real sine 0.0
//
//my cosine   1.0
//real cosine 1.0
//
// my sine  0.09983341664635367
//real sine 0.09983341664682815
//
//my cosine   0.9950041652780733
//real cosine 0.9950041652780733
//
// my sine  0.1986693307941265
//real sine 0.19866933079506122
//
//my cosine   0.9800665778414311
//real cosine 0.9800665778414311
//
// my sine  0.29552020665442036
//real sine 0.2955202066613396
//
//my cosine   0.9553364891277464
//real cosine 0.9553364891277464
//
// my sine  0.3894183423068936
//real sine 0.3894183423086505
//
//my cosine   0.9210609940036278
//real cosine 0.9210609940036278
//
// my sine  0.4794255385990945
//real sine 0.479425538604203
//
//my cosine   0.8775825618931635
//real cosine 0.8775825618931635
//
// my sine  0.5646424733830799
//real sine 0.5646424733950354
//
//my cosine   0.8253356149178575
//real cosine 0.8253356149178575
//
// my sine  0.6442176872361944
//real sine 0.644217687237691
//
//my cosine   0.7648421872857489
//real cosine 0.7648421872857489
//
// my sine  0.7173560908968648
//real sine 0.7173560908995227
//
//my cosine   0.6967067093499022
//real cosine 0.6967067093499022
//
// my sine  0.7833269096232099
//real sine 0.7833269096274833
//
//my cosine   0.6216099682760496
//real cosine 0.6216099682760496
//
// my sine  0.8414709848016061
//real sine 0.8414709848078965
//
//my cosine   0.5403023058779364
//real cosine 0.5403023058779364
//
//Process finished with exit code 0

// cosine was exactly the same and sine had a small margin of error