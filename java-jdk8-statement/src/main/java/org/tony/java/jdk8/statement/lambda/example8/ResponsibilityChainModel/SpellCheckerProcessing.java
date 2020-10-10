package org.tony.java.jdk8.statement.lambda.example8.ResponsibilityChainModel;

/**
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replace("lamda","lambda");
    }
}
