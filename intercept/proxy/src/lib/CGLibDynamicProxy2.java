package lib;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import use.MyProxyInterfaceImplementation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-yablokov-mv on 08.06.2016.
 */
public class CGLibDynamicProxy2 implements MethodInterceptor {
    static public <T> T newInstance(Class<T> objClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objClass);
        enhancer.setCallback(new CGLibDynamicProxy2());

        // just for example
        // it is useless method for this case
        enhancer.setCallbackFilter(new CallbackFilter() {
                                       @Override
                                       public int accept(Method method) {
                                           return 0;
                                       }
                                   }
        );

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return (T) enhancer.create(new Class[]{Object.class, List.class}, new Object[]{new Integer(1), list});
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        try {
            if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                MyMethodAnnotation annotation = method.getAnnotation(MyMethodAnnotation.class);
                if (annotation.isNeedIntercept()) {
                    // ToDo: something
                }
            }
            return methodProxy.invokeSuper(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        MyProxyInterfaceImplementation proxyObj = CGLibDynamicProxy2.newInstance(MyProxyInterfaceImplementation.class);
        proxyObj.getData();
        proxyObj.setData(1);
        proxyObj.setNotGenericData(1);
        proxyObj.setList(null);
    }
}
