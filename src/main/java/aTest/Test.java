package aTest;

import java.util.ArrayList;
import java.util.List;

public class Test {

    void a(){
        int num = 50/0;
    }
    void  b(){
        a();
    }
    void  c(){
        b();
    }
    public static void main(String[] args) {

        Test t = new Test();
        t.c();
    }

}
