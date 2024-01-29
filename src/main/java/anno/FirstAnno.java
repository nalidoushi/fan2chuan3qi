package anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnno {
    String name() default "";
    int age() default 18;
    String [] addrs() default {};
    String value() default "";
}
