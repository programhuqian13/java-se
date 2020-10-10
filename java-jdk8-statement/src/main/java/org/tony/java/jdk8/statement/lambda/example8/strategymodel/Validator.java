package org.tony.java.jdk8.statement.lambda.example8.strategymodel;

/**
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
