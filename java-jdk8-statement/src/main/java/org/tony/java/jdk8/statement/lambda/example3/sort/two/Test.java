package org.tony.java.jdk8.statement.lambda.example3.sort.two;

import java.util.function.Function;

/**
 * Created by tony on 2017/8/21.
 */
public class Test {

    public static void main(String[] args) {

        Function<String,String> f1 = Letter::addHeader;

        Function<String,String> f2 = f1.andThen(Letter::checkSpelling).andThen(Letter::addFooter);

        System.out.println(f2.apply("tony,labda,this is a labda"));

        Function<String,String> f3 = Letter::addHeader;

        Function<String,String> f4 = f3.andThen(Letter::addFooter);

        System.out.println(f4.apply("tony"));

    }
}
