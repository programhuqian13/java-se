package org.tony.java.jdk8.statement.lambda.example3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by tony on 2017/8/17.
 * java.util.function.Function;
 * Function接口定义了一个叫做apply的方法，他接受一个泛型T的对象，并返回一个泛型R的对象。
 * 如果你需要定义一个Lambda，将输入对象的信息映射到输出，就可以用这个接口。
 */
public class FunctionTest {

    public static void main(String[] args) {
        List<Integer> list = map(Arrays.asList("Lambda","in","action"),(String s) -> s.length());
        System.out.println(list);
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T s : list){
            result.add(f.apply(s));
        }
        return result;
    }

}
