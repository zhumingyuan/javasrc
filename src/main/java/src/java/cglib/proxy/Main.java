package src.java.cglib.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class Main {


    static void testInterceptor(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject=(TargetObject)enhancer.create();
        targetObject.request();
    }

    static void testCallbackFilter(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        Callback[] cbArray = new Callback[2];
        cbArray[0] = new TargetInterceptor();
        //NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截
        cbArray[1] = NoOp.INSTANCE;
        enhancer.setCallbacks(cbArray);
        enhancer.setCallbackFilter(new TargetMethodCallbackFilter());
        TargetObject targetObject=(TargetObject)enhancer.create();
        targetObject.call();
        targetObject.request();
    }

    static void testLazyload(){
        LazyBean lazyBean = new LazyBean();
        Bean b1 = lazyBean.getBean1();
        Bean b2 = lazyBean.getBean2();
        b1.getName();
        b1.getName();
        b2.getName();
        b2.getName();
    }


    public static void main(String args[]) {
        testLazyload();
    }
}
