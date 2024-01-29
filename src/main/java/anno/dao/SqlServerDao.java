package anno.dao;

import anno.UseThis;

@UseThis
public class SqlServerDao implements MyDao{
    @Override
    public void add() {
        System.out.println("SqlServer..add..");
    }

    @Override
    public void get() {
        System.out.println("SqlServer..get..");
    }
}
