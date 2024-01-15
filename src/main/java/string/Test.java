package string;

/**
 * 课堂练习:实现方法-getHostName，用于截取一个网址中的域名
 */
public class Test {
    public static void main(String[] args) {
        String url1 = "www.tedu.cn";
        String url2 = "http://www.tarena.com.cn";
        String name1 = getHostName(url1);
        String name2 = getHostName(url2);
        System.out.println(name1);//tedu
        System.out.println(name2);//tarena
    }
    public static String getHostName(String url){//URL
        //1找开始截取的位置(第一个"."之后第一个字符的位置)
        int start = url.indexOf(".")+1;
        //2找到第二个"."的位置(从第一个"."之后第一个字符处开始检索)
        int end = url.indexOf(".",start);
        //3截取两个"."之间的内容
        String name = url.substring(start,end);
        return name;
    }
}
