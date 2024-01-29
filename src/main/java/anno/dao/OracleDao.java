package anno.dao;

import anno.UseThis;


public class OracleDao implements MyDao{
    @Override
    public void add() {
        System.out.println("Oracle..add..");
    }

    @Override
    public void get() {
        System.out.println("Oracle..get..");
    }
}
