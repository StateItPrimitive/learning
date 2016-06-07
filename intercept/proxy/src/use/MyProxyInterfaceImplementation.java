package use;

import lib.MyMethodAnnotation;

import java.util.List;

/**
 * Created by sbt-yablokov-mv on 06.06.2016.
 */
public class MyProxyInterfaceImplementation<T> implements MyProxyInterface<T>, MyProxyInterface2<T> {
    private T data;
    private List<T> list;

    @Override
    public T getData() {
        System.out.println("ֲûחמג " + this.getClass().getName() + ".getData()");
        return data;
    }

    @Override
    @MyMethodAnnotation(isNeedIntercept = true)
    public void setData(T data) {
        System.out.println("ֲûחמג " + this.getClass().getName() + ".setData(" + data + ")");
        this.data = data;
    }

    @Override
    @MyMethodAnnotation(isNeedIntercept = true)
    public void setNotGenericData(Integer data) {
        System.out.println("ֲûחמג " + this.getClass().getName() + ".setNotGenericData(" + data + ")");
    }

    @Override
    @MyMethodAnnotation(isNeedIntercept = true)
    public void setList(List<T> list) {
        System.out.println("ֲûחמג " + this.getClass().getName() + ".setList(" + list + ")");
        this.list = list;
    }
}
