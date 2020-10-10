package org.tony.java.jdk8.statement.lambda.example8.observermodel;

/**
 */
public class LeMonde implements Observer{
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("wine")){
            System.out.println("Today cheese,wine and news!  " + tweet);
        }
    }
}
