package org.tony.java.jdk8.statement.lambda.example3.sort.one;

import org.tony.java.jdk8.statement.lambda.example3.sort.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tony on 2017/8/21.
 * lambda
 */
public class TestLambda {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green",150)
                                        ,new Apple("red",160)
                                        ,new Apple("green",152)
                                        ,new Apple("red",85));

//        list.sort((o1,o2) -> o1.getWeight().compareTo(o2.getWeight()));
//
//        System.out.println(list);

        list.sort(Comparator.comparing((apple -> apple.getWeight())));
        System.out.println(list);
    }
}
