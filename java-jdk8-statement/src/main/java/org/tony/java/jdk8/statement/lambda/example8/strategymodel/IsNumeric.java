package org.tony.java.jdk8.statement.lambda.example8.strategymodel;

/**
 * Created by xuanyi on 2017/8/30.
 */
public class IsNumeric implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
