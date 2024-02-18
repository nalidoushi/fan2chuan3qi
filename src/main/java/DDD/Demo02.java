package DDD;

public class Demo02 {
    public static void main(String[] args) {
        try {
            div(3,0);
        } catch (OutOfMemoryError e) {
            System.out.println("捕获到了~~·");
        }
    }
    public static int div(int a,int b){
        if(b == 0){
            //????
            throw new OutOfMemoryError();
        }
        return a/b;
    }
}
