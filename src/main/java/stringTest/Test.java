package stringTest;

public class Test {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = "abc";
        //System.out.println(str1==str2);
        String str3 = str1.intern();
        System.out.println(str2==str3);
        String str4 = str2.intern();
        System.out.println(str3 == str4);

    }
}
