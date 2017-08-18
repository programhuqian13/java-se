package org.tony.java.jdk8.statement.lambda.example3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by tony on 2017/8/18.
 * Lombda方法引用
 */
public class MethodReference1 {

    public static void main(String[] args) {
        //lambda表达式实现
        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(str);

        //方法引用实现
        str.sort(String::compareToIgnoreCase);   //编译器会进行一种与Lambds表达式类似的类型检查过程，来确定对于给定的函数式接口，这个方法引用是否有效：方法签名必须和上下文类型匹配。
        System.out.println(str);

        Function<String,Integer> string = (String s) -> Integer.parseInt(s);
        Function<String,Integer> stringToInteger = Integer::parseInt;

        BiPredicate<List<String>,String> bp = (List<String> list,String s) -> list.contains(s);
        BiPredicate<List<String>,String> contains = List::contains;
    }
}
