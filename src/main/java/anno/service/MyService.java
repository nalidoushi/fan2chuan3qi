package anno.service;

import anno.dao.MyDao;

public class MyService {
    private MyDao dao = MyDaoFactory.getDao();

    public void test(){
        dao.add();
        dao.get();
    }
}
