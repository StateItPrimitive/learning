package lib;

import use.MyProxyInterface;
import use.MyProxyInterfaceImplementation;

import java.lang.reflect.*;

class MyDynamicProxy implements InvocationHandler {
    Object obj;

    public MyDynamicProxy(Object obj) {
        this.obj = obj;
    }

    static public Object newInstance(Object obj, Class... interfaces)
    {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces, new MyDynamicProxy(obj));
    }

    static public <T> T getNewInstance(T obj) {
        return (T)Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new MyDynamicProxy(obj));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Class<?>[] paramTypes = getMethodParameterTypes(method, args);
            Method declaredMethod = obj.getClass().getMethod(method.getName(), paramTypes);
            if (declaredMethod.isAnnotationPresent(MyMethodAnnotation.class)) {
                MyMethodAnnotation annotation = declaredMethod.getAnnotation(MyMethodAnnotation.class);
                if (annotation.isNeedIntercept()) {
                    // ToDo: something
                }
            }
            return method.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw e;
        }
    }

    private Class<?>[] getMethodParameterTypes(Method method, Object[] args) {
        Class<?>[] paramTypes = null;
        if (null != args) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            if (null == genericParameterTypes || 0 == genericParameterTypes.length) {
                paramTypes = new Class[args.length];
                for (int index = 0; index < args.length; ++index) {
                    paramTypes[index] = args[index].getClass(); //Object.class
                }
            } else {
                for (Method realMethod : obj.getClass().getMethods()) {
                    if (realMethod.getName().equals(method.getName())) {
                        if (realMethod.getParameterCount() == method.getParameterCount()) {
                            paramTypes = realMethod.getParameterTypes();
                            break;
                        }
                    }
                }
            }
        }
        return paramTypes;
    }

    public static void main(String[] args) {
        MyProxyInterfaceImplementation<Integer> obj = new MyProxyInterfaceImplementation<>();
        MyProxyInterface proxyObj = MyDynamicProxy.getNewInstance((MyProxyInterface)obj); // (MyProxyInterface) MyDynamicProxy.newInstance(obj, obj.getClass().getInterfaces())
        proxyObj.getData();
        proxyObj.setData(1);
        proxyObj.setNotGenericData(1);
    }
}