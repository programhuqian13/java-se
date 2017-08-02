package org.tony.java.jdk8.statement.lambda.example2;

/**
 * Created by tony on 2017/8/2.
 * 匿名类的误区
 */
public class MeaningOfThis {

    public final int value = 4;

    public void doIt(){
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value); //这个value打印的值是什么？ 5,因为this指的是包含它的Runnable，而不是外面的类MeaningOfThis
            }
        };
        r.run();
    }

    public static void main(String ... args){
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }

}
