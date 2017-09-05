package org.tony.java.jdk8.statement.lambda.example5;

import org.tony.java.jdk8.statement.lambda.example4.Dish;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by xuanyi on 2017/8/25.
 * 用流收集数据
 * Collectors使用
 * Collectors工厂类提供了很多种收集器实例，汇总，归约，分组等等
 */
public class StreamCollectorsTest {

    static final List<Dish> list;

    static{
        list = Arrays.asList(new Dish("红烧鱼",false,300,Dish.Type.FISH),
                new Dish("aaaa",true,400,Dish.Type.MEAT),
                new Dish("bbbb",false,350,Dish.Type.OTHER),
                new Dish("cccc",true,200,Dish.Type.MEAT),
                new Dish("dddd",false,200,Dish.Type.FISH),
                new Dish("eeee",true,500,Dish.Type.OTHER));
    }

    //收集数据 count
    public static long count1(Stream<Dish> stream){
        return stream.count();  //count方法实际上是运行return mapToLong(e -> 1L).sum(); 这里转换为Long类型的流
    }

    //使用Collectors.counting()
    public static long count2(Stream<Dish> stream){
        return stream.collect(Collectors.counting());   //counting后台的实现也是为reducing进行汇总
    }

    public static Optional<Dish> maxDishBy(Stream<Dish> stream,Comparator<Dish> comparator){
        return stream.collect(maxBy(comparator));
    }

    public static Optional<Dish> minDishBy(Stream<Dish> stream,Comparator<Dish> comparator){
        return stream.collect(minBy(comparator));
    }

    public static Comparator<Dish> dishComparator(){
        return Comparator.comparingInt(Dish::getCalories);
    }

    public static void main(String[] args) {
        System.out.println(count1(list.stream()));
        System.out.println(count2(list.stream()));

        System.out.println(maxDishBy(list.stream(),dishComparator()).get());

        System.out.println(minDishBy(list.stream(),dishComparator()).get());

        //汇总操作
        int total = list.stream().collect(summingInt(Dish::getCalories));
        System.out.println(total);

        Map<Dish.Type,List<Dish>> dishesByGroup = list.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByGroup);

    }



}
