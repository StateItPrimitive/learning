package lib;

import use.AnnotatedClass;

import java.lang.reflect.Method;

/**
 * Created by sbt-yablokov-mv on 05.06.2016.
 */
public class MyAnnonationsReader {
    private static Class<MyClassAnnotation> CLASS_ANNOTATION_CLASS = MyClassAnnotation.class;
    private static Class<MyMethodAnnotation> METHOD_ANNOTATION_CLASS = MyMethodAnnotation.class;

    public static void main(String[] args) {
        run(new Class<?>[]{AnnotatedClass.class});
    }

    public static void run(Class<?>[] annotatedClasses) {
        System.out.println("Start reading classes annotations\n");

        for (Class<?> annotatedClass: annotatedClasses) {
            processClassAnnotation(annotatedClass);
            processMethodAnnotation(annotatedClass);
        }
    }

    public static <T> void run(Class<T> annotatedClass) {
        System.out.println("Start reading class annotation\n");

        processClassAnnotation(annotatedClass);
        processMethodAnnotation(annotatedClass);
    }

    /**
     * process @MyClassAnnotation for each class
     */
    private static <T> void processClassAnnotation(Class<T> annotatedClass) {
        if (annotatedClass.isAnnotationPresent(CLASS_ANNOTATION_CLASS)) {
            MyClassAnnotation annotation = annotatedClass.getAnnotation(CLASS_ANNOTATION_CLASS);

            System.out.println("Reading annotation of class: " + annotatedClass.getName() + "\n");
            System.out.println("Priority: " + annotation.priority());
            System.out.println("Created by: " + annotation.createdBy());

            System.out.print("Tags: ");
            String[] tags = annotation.tags();
            if (tags.length > 0) {
                for (int tagIndex = 0; tagIndex < tags.length - 1; ++tagIndex) {
                    System.out.print(tags[tagIndex] + ", ");
                }
                System.out.println(tags[tags.length - 1]);
            }

            System.out.printf("Last modified: %s%n%n", annotation.lastModified());
        }
    }

    /**
     * process @MyMethodAnnotation for each method
     */
    private static <T> void processMethodAnnotation(Class<T> annotatedClass) {
        int total = 0;
        int passed = 0;
        int failed = 0;
        int ignored = 0;

        for (Method method: annotatedClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(METHOD_ANNOTATION_CLASS)) {
                MyMethodAnnotation annotation = method.getAnnotation(METHOD_ANNOTATION_CLASS);

                if (annotation.enabled()) {
                    try {
                        method.setAccessible(true);
                        method.invoke(annotatedClass.newInstance());

                        ++passed;
                        System.out.printf("%d - Test '%s' - passed %n", ++total, method.getName());
                    }
                    catch (Exception exception) {
                        ++failed;
                        System.out.printf("%d - Test '%s' - failed: %s %n", ++total, method.getName(), exception.getCause());
                    }
                } else {
                    System.out.printf("%d - Test '%s' - ignored %n", ++total, method.getName());
                }
            }
        }
        System.out.println("\nResult:");
        System.out.println("total: " + total);
        System.out.println("passed: " + passed);
        System.out.println("failed: " + failed);
        System.out.println("ignored: " + ignored);
    }
}
