package org.tony.java.jdk8.statement.lambda.example8.strategymodel;

/**
 * Created by xuanyi on 2017/8/30.
 */
@FunctionalInterface
public interface ValidationStrategy {
    boolean execute(String s);
}
