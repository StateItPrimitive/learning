package lib;

import java.lang.annotation.*;

/**
 * Created by sbt-yablokov-mv on 05.06.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyMethodAnnotation {
    boolean enabled() default true;
    boolean isNeedIntercept() default false;
}
