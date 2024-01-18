package type;

public class TransferObject3<T> {
    public T doSome(T t){
        return null;
    }
    /*
        当一个方法希望方法参数的类型与返回值类型一致，并且由使用者
        决定类型时，可以在方法上单独声明一个泛型
     */
    public<E> E doSome2(E e){
        return e;
    }
}
