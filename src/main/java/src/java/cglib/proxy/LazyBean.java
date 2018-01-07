package src.java.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;

public class LazyBean {

    Bean bean1;

    Bean bean2;

    LazyBean(){
        createBean1();
        createBean2();
    }

    void createBean1(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Bean.class);
        bean1 = (Bean) enhancer.create(Bean.class,
                new ConcreteLazyLoader());
    }

    void createBean2(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Bean.class);
        bean2 = (Bean) enhancer.create(Bean.class,
                new ConcreteDispatcher());
    }


    public Bean getBean1() {
        return bean1;
    }

    public Bean getBean2() {
        return bean2;
    }
}
