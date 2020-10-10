package org.tony.java.jdk8.statement.lambda.example8.observermodel;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Feed implements Subject{

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
