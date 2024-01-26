package reflect;

public class MySqlDao implements MyDao {
    public void save(){
        System.out.println("MySql保存数据..");
    }
    public void get(){
        System.out.println("MySql获取数据..");
    }
}
