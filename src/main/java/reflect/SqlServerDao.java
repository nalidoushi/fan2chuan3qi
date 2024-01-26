package reflect;

public class SqlServerDao implements MyDao {
    @Override
    public void save() {
        System.out.println("SqlServer 保存数据..");
    }

    @Override
    public void get() {
        System.out.println("SqlServer 获取数据..");
    }
}
