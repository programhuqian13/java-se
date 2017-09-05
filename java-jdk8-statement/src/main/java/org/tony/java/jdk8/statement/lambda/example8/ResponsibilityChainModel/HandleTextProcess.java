package org.tony.java.jdk8.statement.lambda.example8.ResponsibilityChainModel;

/**
 * Created by xuanyi on 2017/9/4.
 */
public class HandleTextProcess extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Role maric and alan: " + input;
    }
}
