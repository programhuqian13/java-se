package org.tony.java.jdk8.statement.lambda.example3.sort.one;

import org.tony.java.jdk8.statement.lambda.example3.sort.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tony on 2017/8/21.
 * 匿名类
 */
public class Test2 {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green",150)
                                        ,new Apple("red",160)
                                        ,new Apple("green",152)
                                        ,new Apple("red",85));
        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(list);
    }
}
