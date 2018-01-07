package src.java.cglib.proxy;

public class TargetObject {

    public void call(){
        System.out.println("do call target object ! ");
    }

    public void request(){
        System.out.println("request ... ");
    }
}
