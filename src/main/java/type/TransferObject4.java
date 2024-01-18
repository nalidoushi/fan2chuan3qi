package type;

/**
 * 静态方法不能引用类上的泛型，因为加载优先级问题。
 * 因为类上的泛型时在实例化对象时指定类型的，而静态方法是在不实例化对象就可以引用的方法，因此
 * 它无法使用类上的泛型。
 * @param <T>
 */
public class TransferObject4<T> {
//    public static T doSome(T e){...}//编译不通过

    public static<E>  E doSome(E e){
        return null;
    }
}
