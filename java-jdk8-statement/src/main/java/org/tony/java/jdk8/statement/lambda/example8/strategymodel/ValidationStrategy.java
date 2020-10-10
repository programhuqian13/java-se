package org.tony.java.jdk8.statement.lambda.example8.strategymodel;

/**
 */
@FunctionalInterface
public interface ValidationStrategy {
    boolean execute(String s);
}
