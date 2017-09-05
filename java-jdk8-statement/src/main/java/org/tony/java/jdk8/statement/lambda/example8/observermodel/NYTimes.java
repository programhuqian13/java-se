package org.tony.java.jdk8.statement.lambda.example8.observermodel;

/**
 * Created by xuanyi on 2017/8/30.
 */
public class NYTimes implements Observer{
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")){
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
