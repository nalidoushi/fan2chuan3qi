package io;

import java.io.*;

class Point implements Serializable {
    /**对象序列化时的一个唯一标识，对象反序列化时也会参考这个id进行实现，不提供
     * 此id，在序列化时默认也会生成，但一旦类结构发生变化，反序列化就会失败，
     * 所以从代码严谨上来讲，建议需要序列化的对象都要手动生成一个这样的id*/
    private static final long serialVersionUID = -8605337614925028892L;
    private int x;
    private int y;
    private int z;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class SerializableDemo {
    /**序列化*/
    static void serialize(Point point) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream("oos.dat"));
        oos.writeObject(point);
        oos.flush();
        oos.close();
    }
    /**反序列化*/
    static Point deserialize() throws IOException, ClassNotFoundException {
       ObjectInputStream ois=new ObjectInputStream(new FileInputStream("oos.dat"));
       Point point=(Point)ois.readObject();
       ois.close();
       return point;
    }
    public static void main(String[] args)throws Exception {
        Point p1=new Point();
        p1.setX(10);
        p1.setY(20);
        serialize(p1);
        Point p2=deserialize();//创建新对象
        System.out.println(p2);
        System.out.println(p1==p2);//false
        System.out.println(p1.equals(p2));//false
    }
}
