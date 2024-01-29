package anno;

import java.net.URL;

public class Demo04 {
    public static void main(String[] args) {
        URL url1 = Demo04.class.getResource(".");
        System.out.println(url1);
        URL url2 = Demo04.class.getResource("/");
        System.out.println(url2);
        URL url3 = Demo04.class.getClassLoader().getResource(".");
        System.out.println(url3);
        URL url4 = Demo04.class.getClassLoader().getResource("/");
        System.out.println(url4);
    }
}
