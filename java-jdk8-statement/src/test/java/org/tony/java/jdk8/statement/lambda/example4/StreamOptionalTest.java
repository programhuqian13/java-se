package org.tony.java.jdk8.statement.lambda.example4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by tony on 2017/8/22.
 * Optional<T> 类是一个容器类，代表一个值存在或者不存在。
 */
public class StreamOptionalTest {

    public static void main(String[] args) {
        List<Dish> list = Arrays.asList(new Dish("红烧鱼",false,300,Dish.Type.FISH),
                new Dish("aaaa",true,400,Dish.Type.MEAT),
                new Dish("bbbb",false,350,Dish.Type.OTHER),
                new Dish("cccc",true,200,Dish.Type.MEAT),
                new Dish("dddd",false,200,Dish.Type.FISH),
                new Dish("eeee",true,500,Dish.Type.OTHER));

        //ifPresent()方法会在值存在的时候指定给定的代码块
        list.stream()
                .filter(Dish::isVegetarian)
                .findAny()   //返回一个Optional<Dish>
                .ifPresent(d -> System.out.println(d.getName()));   //如果包含一个值就打印，否则什么也不做

        //查找第一个元素
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                                                                        .map(x -> x * x)
                                                                        .filter(x -> x % 3 == 0)
                                                                        .findFirst();
        // Optional<T>.get()方法会在值存在的时候返回值，否则抛出NoSuchElement异常
        System.out.println(firstSquareDivisibleByThree.get());

        //reduce()方法lambda反复结合每个元素，直到流被归约成一个值
        //reduce接受两个参数：1.一个初始值，这里为0 2.一个BinaryOperator<T>来将两个元素结合起来产生一个新值。
        System.out.println(someNumbers.stream().reduce(0,Integer::sum));

        //reduce无初始值
        Optional<Integer> sum = someNumbers.stream().reduce((a,b) ->(a + b));
        System.out.println(sum.get());
    }

}
