package use;

import lib.MyClassAnnotation;
import lib.MyMethodAnnotation;

import static lib.MyClassAnnotation.Priority.*;

@MyClassAnnotation(
    priority = HIGHT,
    createdBy = "Max Yablokov",
    tags = {"firstTag", "secondTag"}
)
public class AnnotatedClass {
    @MyMethodAnnotation
    void implicitlyEnabledMethod() throws RuntimeException {
        throw new RuntimeException("This method must throw exception!");
    }

    @MyMethodAnnotation(enabled = true)
    public void clearlyEnabledMethod() {
        // all right
    }

    @MyMethodAnnotation(enabled = false)
    public void clearlyDisabledMethod() {
        throw new RuntimeException("This method1 should not be called!");
    }
}
