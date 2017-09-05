package org.tony.java.jdk8.statement.lambda.example8.ResponsibilityChainModel;

/**
 * Created by xuanyi on 2017/9/4.
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replace("lamda","lambda");
    }
}
