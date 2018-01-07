package src.java.cglib.proxy;

import net.sf.cglib.proxy.LazyLoader;

public class ConcreteLazyLoader implements LazyLoader{

    @Override
    public Object loadObject() throws Exception {

        System.out.println("before lazy loader ...");
        Bean bean = new Bean("lazy loader");
        System.out.println("after lazy loader ...");
        return bean;
    }
}
