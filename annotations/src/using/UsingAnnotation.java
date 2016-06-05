package using;

import lib.MyClassAnnotation;
import lib.MyMethodAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static lib.MyClassAnnotation.Priority.*;

@MyClassAnnotation(
    priority = HIGHT,
    createdBy = "Max Yablokov",
    tags = {"firstTag", "secondTag"}
)
public class UsingAnnotation {
    @MyMethodAnnotation
    void method1() throws RuntimeException {
        if (true)
            throw new RuntimeException("This method1 should not be called!");
    }

    @MyMethodAnnotation(enabled = false)
    public void method2() {
        if (false)
            throw new RuntimeException("This method2 always passed!");
    }

    @MyMethodAnnotation(enabled = true)
    public void method3() {
        int a = 1;
        if (10 > 1)
            a = 2;
    }

    @MyMethodAnnotation(enabled = true)
    public void method4() {
        int a = 1;
        if (10 > 1)
            a = 2;
    }
}
