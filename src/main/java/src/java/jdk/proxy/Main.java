package src.java.jdk.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {

    static void proxy1() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException{
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(Hello.class.getClassLoader(),Hello.class);
        //获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        Hello hello = (Hello) constructor.newInstance(new HelloInvocationHandler(new HelloImpl()));
        //通过代理对象调用目标方法
        hello.say();
    }

    static void proxy2(){
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Hello  hello2 = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),  //加载接口的类加载器
                new Class[]{Hello.class},      //一组接口
                new HelloInvocationHandler(new HelloImpl())); //自定义的InvocationHandler
        hello2.say();
    }


    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        proxy1();
        proxy1();
    }
}
