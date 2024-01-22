package exception;
/**
 * 自定义异常
 */
public class PhoneNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -6274120866460982066L;
    public PhoneNotFoundException() {
    }
    public PhoneNotFoundException(String message) {
        super(message);
    }
    public PhoneNotFoundException(Throwable e) {
        super(e);
    }
}
