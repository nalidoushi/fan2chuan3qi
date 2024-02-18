package DDD;

class DivZeroException extends RuntimeException{
}

public class Demo02 {
    public static void main(String[] args) {
        try {
            div(3,0);
        } catch (DivZeroException e) {
            e.printStackTrace();
        }
    }

    public static int div(int a,int b) {
        if(b == 0){
            throw new DivZeroException();
        }
        return a/b;
    }
}
