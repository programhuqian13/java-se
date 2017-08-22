package org.tony.java.jdk8.statement.lambda.example3.sort.one;

import org.tony.java.jdk8.statement.lambda.example3.sort.Apple;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BF100395 on 2017/8/21.
 */
public class Test {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green",150)
                                        ,new Apple("red",160)
                                        ,new Apple("green",152)
                                        ,new Apple("red",85));
        list.sort(new AppleComparator());

        System.out.println(list);

    }
}
