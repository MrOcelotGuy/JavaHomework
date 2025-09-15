import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class FencePaint
{

    static int calculateOverlap(int a, int b, int c, int d) {
        int[] pair1 = new int[2];
        int[] pair2 = new int[2];

        if (a<c)
        {
            pair1[0] = a;
            pair1[1] = b;

            pair2[0] = c;
            pair2[1] = d;
        }
        else
        {
            pair1[0] = c;
            pair1[1] = d;

            pair2[0] = a;
            pair2[1] = b;
        }

        boolean overlap = (pair2[0] >= pair1[0] &&  pair2[0] <= pair1[1]);

        if(overlap && pair2[1] >= pair1[1])
        {
            return (pair2[1]-pair1[0]);
        }
        else if(overlap)
        {
            return pair1[1]-pair1[0];
        }
        else
        {
            return ((pair1[1]-pair1[0]) + (pair2[1]-pair2[0]));
            }
        }

    static void runTests(String path, int numberOfTests) throws IOException {
        for (int i=1; i<=numberOfTests; i++) {
            if (checkTests(path, i)) {
                System.out.println(i + " passed");
            } else {
                System.out.println(i + " failed");
            }
        }
    }

    static boolean checkTests(String path, int testNumber) throws IOException {
        var in = Files.readAllLines(Path.of(path).resolve(testNumber+".in"));
        var out = Files.readString(Path.of(path).resolve(testNumber+".out")).trim();

        var firstLine = in.get(0).split(" ");
        var secondLine = in.get(1).split(" ");

        var a = Integer.parseInt(firstLine[0]);
        var b = Integer.parseInt(firstLine[1]);
        var c = Integer.parseInt(secondLine[0]);
        var d = Integer.parseInt(secondLine[1]);

        var myResult = calculateOverlap(a, b, c, d);
        return (myResult == Integer.parseInt(out));
    }

    public static void main(String[] args) throws IOException {

        runTests("/Users/diegomeneses/Downloads/fence_painting_test_cases"
                , 10);

//        boolean overlap = a < c && c< b || a < d < b || c < a < d || c < b < d;
//

//        if(!overlap)
//        {
//            System.out.println((b-a)+(d-c));
//        }
//        else if(d < b)
//        {
//            System.out.println(b-c);
//        }
//        else
//        {
//            System.out.println(d-c);
//        }
    }
}