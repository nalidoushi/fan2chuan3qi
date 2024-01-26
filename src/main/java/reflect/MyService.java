package reflect;

public class MyService {
    //MySqlDao dao = new MySqlDao();
    //OracleDao dao = new OracleDao();
    MyDao dao = MyDaoFactory.getDao();

    public void mx(){
        dao.save();
        dao.get();
    }
}
