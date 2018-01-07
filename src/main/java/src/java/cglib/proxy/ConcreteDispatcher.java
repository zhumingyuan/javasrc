package src.java.cglib.proxy;

import net.sf.cglib.proxy.Dispatcher;

public class ConcreteDispatcher implements Dispatcher {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("before dispatcher ....");
        Bean bean = new Bean("dispatcher");
        System.out.println("after dispatcher ...");
        return bean;
    }
}
