package lib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import use.MyProxyInterfaceImplementation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by sbt-yablokov-mv on 07.06.2016.
 */
public class CGLibDynamicProxy implements MethodInterceptor {
    Object obj;

    public CGLibDynamicProxy(Object obj) {
        this.obj = obj;
    }

    static public <T> T getNewInstance(T obj) {
        return (T) Enhancer.create(obj.getClass(), new CGLibDynamicProxy(obj));
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        try {
            if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                MyMethodAnnotation annotation = method.getAnnotation(MyMethodAnnotation.class);
                if (annotation.isNeedIntercept()) {
                    // ToDo: something
                }
            }
            return methodProxy.invoke(obj, args); // method.invoke(obj, args) why not?
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        MyProxyInterfaceImplementation<Integer> obj = new MyProxyInterfaceImplementation<>();

        MyProxyInterfaceImplementation proxyObj = CGLibDynamicProxy.getNewInstance(obj);
        proxyObj.getData();
        proxyObj.setData(1);
        proxyObj.setNotGenericData(1);
        proxyObj.setList(null);
    }
}
