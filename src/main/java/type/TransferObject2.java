package type;

import java.util.Collection;
import java.util.Collections;

/**
 * 泛型的边界
 *
 * 可以在定义泛型时使用extends为其指定上边界，此时实际指定泛型的类型只能是上边界要求的类型
 * 或者其子类型才可以
 */
public class TransferObject2<T extends Collection> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
