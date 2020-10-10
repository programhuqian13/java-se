package org.tony.java.jdk8.statement.lambda.example8.observermodel;

/**
 */
public interface Subject {

    void registerObserver(Observer o);  //注册一个新的观察者

    void notifyObserver(String tweet);  //通知观察者

}
