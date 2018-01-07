package src.java.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInvocationHandler implements InvocationHandler {

    //目标对象
    private Object target;

    public HelloInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------befor hello-------------");
        //执行相应的目标方法
        Object rs = method.invoke(target, args);
        System.out.println("------after hello-------------");
        return rs;
    }
}
