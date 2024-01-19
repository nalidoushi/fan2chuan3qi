package aTest;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<Object> l2 = new ArrayList<>();
        System.out.println(l1.getClass() == l2.getClass());
    }

}
