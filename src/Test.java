import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("red");
        Set set2 =  (LinkedHashSet)((HashSet)set1).clone()  ;
    }
}