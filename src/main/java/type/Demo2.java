package type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 测试泛型的边界
 */
public class Demo2 {
    public static void main(String[] args) {
        /*
            public class TransferObject2<T extends Collection>
            要求泛型的实际类型应当是Collection或其子类
         */
        //String与Collection没有继承关系，编译不通过
//        TransferObject2<String> t1 = new TransferObject2<>();

        //Collection或者其子类型作为泛型实际类型均可以
        TransferObject2<Collection> t2 = new TransferObject2<>();
        TransferObject2<ArrayList> t3 = new TransferObject2<>();
        TransferObject2<HashSet> t4 = new TransferObject2<>();
    }
}
