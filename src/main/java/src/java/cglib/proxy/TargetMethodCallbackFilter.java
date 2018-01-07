package src.java.cglib.proxy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class TargetMethodCallbackFilter implements CallbackFilter{

    @Override
    public int accept(Method method) {
        if(method.getName().equals("call")){
            return 0;
        }
        if(method.getName().equals("request")){
            return 1;
        }
        return 0;
    }
}
