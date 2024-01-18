package type;

/**
 * 测试泛型的应用
 */
public class Demo {
    public static void main(String[] args) {
        //使用时可以不指定泛型的实际类型，不指定时使用默认的原型Object
        TransferObject t1 = new TransferObject();
        t1.setFromUser("范传奇");
        t1.setToUser("王克晶");
        //setData(T d) -> 不指定时编译器就当是Object看待 -> setData(Object d)
//        t1.setData("你好！");
        t1.setData(123);//自动装箱Integer

        TransferObject<String> t2 = new TransferObject<>();
        //setData(T d)->setData(String d)
//        t2.setData(123);//编译不通过，编译器会检查实参类型是否符合泛型要求
        t2.setData("你好!");

        TransferObject<Integer> t3 = new TransferObject<>();
//        t3.setData("你好!");//编译不通过
        t3.setData(123);

        /*
            T getData()
         */
        /*
            以t1角度，没有指定泛型是T为原型Object
            返回时需要自行完成造型工作
            可能存在造型异常:ClassCastException
         */
//        String s = (String)t1.getData();//如果不判定类型贸然造型可能存在上述异常
        Integer i = (Integer)t1.getData();

        //以t2角度泛型指定名为String，因此接受时无需造型
        String s = t2.getData();//编译后编译器会补充造型代码String s = (String)t2.getData();

        Integer num = t3.getData();
        int n = t3.getData();//还会自动拆箱
    }
}
