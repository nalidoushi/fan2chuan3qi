package apidoc;

public class Demo {
    public static void main(String[] args) {
        //鼠标放在类上IDEA会用文档注释做提示
        DocDemo docDemo = new DocDemo();
        //方法上也是如此
        docDemo.sayHello("传奇");
    }
}
