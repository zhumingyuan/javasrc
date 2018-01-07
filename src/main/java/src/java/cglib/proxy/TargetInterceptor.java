package src.java.cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method,
                            Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before do call............");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after do call............");
        return result;
    }
}
