package aTest;

class UserInfo implements Cloneable{
    public int age;
    public UserInfo(int age){
        this.age = age;
    }
    @Override
    protected UserInfo clone()throws CloneNotSupportedException{

        return (UserInfo) super.clone();
    }
}
class User implements Cloneable{
    public String name;
    public String pass;
    public UserInfo info;
    public User(String name,String pass,UserInfo info){
        this.name = name;
        this.pass = pass;
        this.info = info;
    }
    @Override
    protected User clone()throws CloneNotSupportedException{
        User user = (User)super.clone();
        user.info = this.info.clone();
        return user;
    }
}

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User("zhangsan","123456",new UserInfo(20));
        User user2 = user1.clone();
        System.out.println(user1.info.age);
        System.out.println(user2.info.age);
        user1.info.age = 15;
        System.out.println("修改后的值");
        System.out.println(user1.info.age);
        System.out.println(user2.info.age);

    }

}
