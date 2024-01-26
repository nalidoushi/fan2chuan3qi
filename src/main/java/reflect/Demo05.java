package reflect;

/**
 * 反射的应用案例:通常用在框架级别代码中
 */
public class Demo05 {
    public static void main(String[] args) throws Exception, IllegalAccessException {
        MyService service = new MyService();
        service.mx();
    }
}
