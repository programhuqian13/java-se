package org.tony.java.jdk8.statement.lambda.example8.strategymodel;

import org.tony.java.jdk8.statement.lambda.example8.strategymodel.IsAllLowerCase;
import org.tony.java.jdk8.statement.lambda.example8.strategymodel.IsNumeric;
import org.tony.java.jdk8.statement.lambda.example8.strategymodel.Validator;

/**
 * Created by xuanyi on 2017/8/30.
 * 策略模式
 */
public class Test {

    public static void main(String[] args) {
        //不使用lambda
        Validator validator = new Validator(new IsNumeric());
        boolean b1 = validator.validate("aaa");
        System.out.println(b1);

        Validator validator1 = new Validator(new IsAllLowerCase());
        boolean b2 = validator1.validate("bbbb");
        System.out.println(b2);

        //使用lambda表达式
        Validator validator2 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b3 = validator2.validate("aaaa");
        System.out.println(b3);

        Validator validator3 = new Validator((String s) -> s.matches("\\d+"));
        boolean b4 = validator3.validate("bbbb");
        System.out.println(b4);
    }
}
