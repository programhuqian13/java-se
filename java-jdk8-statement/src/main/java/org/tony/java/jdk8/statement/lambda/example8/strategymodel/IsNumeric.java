package org.tony.java.jdk8.statement.lambda.example8.strategymodel;

/**
 */
public class IsNumeric implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
