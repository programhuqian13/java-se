package org.tony.java.jdk8.statement.lambda.example8.ResponsibilityChainModel;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 责任链模式
 */
public class Test {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HandleTextProcess();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);

        String result = p1.handle("this is lamda,really?");
        System.out.println(result);

        //使用lambda表达式
        UnaryOperator<String> headerProcessing = (String text) -> "From Role maric and alan:" + text;

        UnaryOperator<String> spellCheckerProceings = (String text) -> text.replace("lamda","lambda");

        Function<String,String> pipeline = headerProcessing.andThen(spellCheckerProceings);

        String resultLambda = pipeline.apply("this is lamda,really?");

        System.out.println(resultLambda);
    }
}
