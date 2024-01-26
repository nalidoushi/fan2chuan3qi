package reflect;

public class OracleDao implements MyDao {

    @Override
    public void save() {
        System.out.println("Oracle 保存数据..");
    }

    @Override
    public void get() {
        System.out.println("Oracle 获取数据..");
    }
}
