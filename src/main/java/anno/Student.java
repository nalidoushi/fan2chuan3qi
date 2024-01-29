package anno;

@FirstAnno(name="zs",addrs={"bj","sh","gz"})
public class Student {
    @FirstAnno(name="ls",addrs= "bj")
    private String name;
    private int age;

    @FirstAnno("xx")
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //@FirstAnno
    public void eat(/*@FirstAnno*/ String food){
        //@FirstAnno
        int n = 3;
        System.out.println("吃.."+food+n+"份..");
    }
}
