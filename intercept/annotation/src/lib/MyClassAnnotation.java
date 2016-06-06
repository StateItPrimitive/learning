package lib;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyClassAnnotation {
    enum Priority { LOW, MEDIUM, HIGHT }

    Priority priority() default Priority.MEDIUM;
    String[] tags() default "";
    String createdBy() default "Mkyong";
    String lastModified() default "03/01/2014";
}
