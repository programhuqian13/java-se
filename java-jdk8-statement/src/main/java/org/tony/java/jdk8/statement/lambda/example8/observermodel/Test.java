package org.tony.java.jdk8.statement.lambda.example8.observermodel;

/**
 * Created by xuanyi on 2017/8/30.
 * 观察者模式
 */
public class Test {

    public static void main(String[] args) {
        //不使用lambda表达式的情况
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObserver("The queen said her favourite book is Java 8 in Action");

        //使用lambda表达式
        f.registerObserver((String tweet) ->{
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        f.registerObserver((String tweet) ->{
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        f.notifyObserver("The queen said her favourite book is Java 8 in Action");

    }
}
