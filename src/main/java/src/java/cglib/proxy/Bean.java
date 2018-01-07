package src.java.cglib.proxy;

public class Bean {


    Bean(){}
    Bean(String name){
        this.name = name;
    }

    String name;

    String getName(){
        return name;
    }
}
