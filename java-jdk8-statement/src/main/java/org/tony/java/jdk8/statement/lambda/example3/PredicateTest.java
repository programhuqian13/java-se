package org.tony.java.jdk8.statement.lambda.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by tony on 2017/8/17.
 * java.util.function.Predicate;
 * 接口定义了一个名叫test的抽象方法，他接受泛型T对象，并返回一个boolean。
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();
        List<String> list = new ArrayList<>();
        list.add("huqian");
        list.add("");
        list.add("hello");
        List<String> str = filter(list,nonEmptyString);
        System.out.println(str);
    }

    public static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> results = new ArrayList<>();
        for (T s:list) {
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }

}
