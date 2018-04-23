package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {

    private Object obj;

    public DynamicSubject(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        method.invoke(obj, objects);
        return null;
    }
}
