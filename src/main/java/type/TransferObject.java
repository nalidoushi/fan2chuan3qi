package type;

/**
 * JDK5之后推出的特性:泛型
 * 泛型也称为参数化类型，它可以用于在使用一个类时指明某个属性或方法参数或方法返回值的类型。
 * 使得一个类设计时无需明确说明对应的类型，而是转交给使用者决定，来提高程序的灵活性和适配度
 */
public class TransferObject<T> {
    private String fromUser;
    private String toUser;
    private T data;//泛型可以用来指定类中某个属性的类型

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public T getData() {//泛型可以指定方法的返回值类型
        return data;
    }

    public void setData(T data) {//泛型可以指定方法的参数类型
        this.data = data;
    }
}
