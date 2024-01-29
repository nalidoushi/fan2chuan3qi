package anno.dao;

import anno.UseThis;


public class MySqlDao implements MyDao{
    @Override
    public void add() {
        System.out.println("MySql..add..");
    }

    @Override
    public void get() {
        System.out.println("MySql..get..");
    }
}
