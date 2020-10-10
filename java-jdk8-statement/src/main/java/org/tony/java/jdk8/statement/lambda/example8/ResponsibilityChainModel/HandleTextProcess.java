package org.tony.java.jdk8.statement.lambda.example8.ResponsibilityChainModel;

/**
 */
public class HandleTextProcess extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Role maric and alan: " + input;
    }
}
