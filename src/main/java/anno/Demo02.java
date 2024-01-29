package anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
enum PL{
    协警,交警,刑警,警督
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Level{
    PL value() default PL.协警;
}

@Level(PL.警督)
class Police{
    public static void faKuan(){
        System.out.println("罚款200元..");
    }
}

public class Demo02 {
    public static void main(String[] args) {
        Police.faKuan();
        if(Police.class.isAnnotationPresent(Level.class)){
            Level anno = Police.class.getAnnotation(Level.class);
            PL pl = anno.value();
            if(pl == PL.协警){
                System.out.println("大哥,抽根烟,少罚点行不行,给你50得了~~~");
            }else if(pl == PL.交警){
                System.out.println("交200走人..");
            }else if(pl == PL.刑警){
                System.out.println("给了钱赶紧跑,别查出别的事~~~");
            }else{
                System.out.println("首长好,200够不够,不够还有~~~");
            }

        }else{
            System.out.println("你个假警察!打一顿,扭送派出所~~~");
        }
    }
}
