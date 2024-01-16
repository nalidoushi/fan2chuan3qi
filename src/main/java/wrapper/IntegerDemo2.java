package wrapper;

public class IntegerDemo2 {
    public static void main(String[] args) {
        /*
            数字类型的包装类都提供了两个常量用于表示对应基本类型的取值范围
         */
        int imax = Integer.MAX_VALUE;
        int imin = Integer.MIN_VALUE;
        System.out.println(imax);
        System.out.println(imin);
        long lmax = Long.MAX_VALUE;
        long lmin = Long.MIN_VALUE;
        System.out.println(lmax);
        System.out.println(lmin);



        String str = "123";
//        String str = "123.123";//不能转换为整数
        /*
            java.lang.NumberFormatException 数字格式异常
            包装类的parseXXX方法有一个要求:字符串必须正确描述了基本类型可以保存的值
            否则会抛出上述异常
         */
        int a = Integer.parseInt(str);
        System.out.println(a);//123
        double d = Double.parseDouble(str);
        System.out.println(d);//123.123
    }
}
