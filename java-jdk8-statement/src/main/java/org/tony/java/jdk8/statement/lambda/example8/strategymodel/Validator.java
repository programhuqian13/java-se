package org.tony.java.jdk8.statement.lambda.example8.strategymodel;

/**
 * Created by xuanyi on 2017/8/30.
 */
public class Validator {

    private final ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String s){
        return validationStrategy.execute(s);
    }
}
