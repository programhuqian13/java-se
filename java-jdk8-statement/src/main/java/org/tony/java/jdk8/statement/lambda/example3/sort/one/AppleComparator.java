package org.tony.java.jdk8.statement.lambda.example3.sort.one;

import org.tony.java.jdk8.statement.lambda.example3.sort.Apple;

import java.util.Comparator;

/**
 * Created by tony on 2017/8/21.
 */
public class AppleComparator implements Comparator<Apple>{
    @Override
    public int compare(Apple apple1, Apple apple2) {
        return apple1.getWeight().compareTo(apple2.getWeight());
    }
}
