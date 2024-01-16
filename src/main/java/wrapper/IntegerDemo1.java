package wrapper;

/**
 * 包装类
 * java为8个基本类型定义了对应的8个包装类.
 * 目的:让基本类型可以以"对象"形式存在,便于参与面向对象的开发
 *
 * 基本类型             包装类
 * byte             java.lang.Byte
 * short            java.lang.Short
 * int              java.lang.Integer
 * long             java.lang.Long
 * float            java.lang.Float
 * double           java.lang.Double
 * char             java.lang.Character
 * boolean          java.lang.Boolean
 */
public class IntegerDemo1 {
    public static void main(String[] args) {
        int a = 127;
        //将基本类型转换为包装类,以对象形式表示
//        Integer i1 = new Integer(a);
//        Integer i2 = new Integer(a);
        //Integer的valueOf创建包装类对象时会重用1字节之内的整数对象
        Integer i1 = Integer.valueOf(a);//java推荐使用包装类的valueOf转换
        Integer i2 = Integer.valueOf(a);

        System.out.println(i1==i2);
        System.out.println(i1.equals(i2));//true

        double dou = 128.128;
        //Double的valueOf就没有任何重用性
        Double d1 = Double.valueOf(dou);
        Double d2 = Double.valueOf(dou);
        System.out.println(d1==d2);//false
        System.out.println(d1.equals(d2));//true

        /*
            包装类也可以还原基本类型
         */
        //将包装类中保存的基本类型值返回
        double dd = d1.doubleValue();
        System.out.println(dd);
        int in = d1.intValue();//将Double包装类中的小数以整数形式返回(强转为整数)
        System.out.println(in);
        byte b = d1.byteValue();//存在溢出问题
        System.out.println(b);



    }
}

