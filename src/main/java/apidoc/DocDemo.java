package apidoc;

/**
 * 文档注释，是功能级别的注释，用来说明一个类，或方法，或常量的功能
 * 文档注释可以被java提供的命令javadoc生成为手册
 *
 * @author 范传奇
 * @version 1.0
 * @see java.lang.String
 * @since jdk1.8
 */
public class DocDemo {
    /**
     * sayHello方法中的问候语
     */
    public static final String INFO = "你好:";
    /**
     * 为用户添加问候语
     * @param name 指定的用户名
     * @return     返回一个字符串，含有对该用户的问候语
     */
    public String sayHello(String name){
        return INFO + name;
    }
}



