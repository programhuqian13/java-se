package org.tony.java.jdk8.statement.lambda.example3;

/**
 * Created by tony on 2017/8/3.
 */
public class Example1 {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello World!");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!2");
            }
        };

        process(r);

        process(r2);

        process(() -> System.out.println("hello world!3"));
    }

    public static void process(Runnable r){
        r.run();
    }


}
