package org.tony.java.jdk8.statement.lambda.example4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tony on 2017/8/22.
 * Java8中的stream只能消费一次
 */
public class StreamTest2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java8","lambda","stream");
        Stream<String> s = list.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);   //这一句会抛出异常 stream has already been operated upon or closed  因此流只能使用一次
    }
}
