package anno;

@FirstAnno
public class Student {
    @FirstAnno
    private String name;
    private int age;

    @FirstAnno
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @FirstAnno
    public void eat(@FirstAnno String food){
        @FirstAnno
        int n = 3;
        System.out.println("吃.."+food+n+"份..");
    }
}
