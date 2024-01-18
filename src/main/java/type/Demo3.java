package type;

/**
 * 测试方法上定义的泛型
 */
public class Demo3 {
    public static void main(String[] args) {
        TransferObject3<String> t = new TransferObject3();
        String s = t.doSome("hello");
//        int i = t.doSome(123);//不符合类上泛型要求

        //方法自己的泛型，只要参数与返回值类型一致即可
        String s1 = t.doSome2("hello");
        int i = t.doSome2(123);
        String[] array = t.doSome2(new String[3]);
    }
}
