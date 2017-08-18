package org.tony.java.jdk8.statement.lambda.example3;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by tony on 2017/8/18.
 * Lombda构造函数引用
 */
public class ConstructorMethodReference {

    public static void main(String[] args) {

        /**
         * 在没有参数的情况下
         */
        //不用方法引用的方式
        Supplier<Apple> appleSupplier = () -> new Apple();
        Apple apple2 = appleSupplier.get();
        System.out.println(apple2);
        Supplier<Apple> supplier = Apple::new;   //构造函数引用
        Apple apple = supplier.get();
        System.out.println(apple);

        /***
         * 在构造函数有参数的情况下
         */
        //一个参数的情况
        Function<Integer,Apple> appleFunction2 = (weight) -> new Apple(weight);
        Apple appleFun2 = appleFunction2.apply(110);
        System.out.println(appleFun2.toString());
        Function<Integer,Apple> appleFunction = Apple::new; //构造函数引用
        Apple appleFun = appleFunction.apply(110);
        System.out.println(appleFun.toString());

        //一个参数的情况
        List<Integer> list = Arrays.asList(54,2,3,5);
        List<Apple> apples = map(list,Apple::new);
        System.out.println(apples);

        BiFunction<String,Integer,Apple> appleBiFunction2 = (string,weight) -> new Apple(string,weight);
        System.out.println(appleBiFunction2.apply("greenApple",20));

        BiFunction<String,Integer,Apple> appleBiFunction = Apple::new;
        Apple appleBiFunction1 = appleBiFunction.apply("redApple",15);
        System.out.println(appleBiFunction1);

        System.out.println(giveAllApple("blue",10));
    }

    static Map<String,BiFunction<String,Integer,Apple>> map = new HashMap<>();

    static{
       map.put("blue",Apple::new);
       map.put("white",Apple::new);
       map.put("yello",Apple::new);
    }

    public static List<Apple> map(List<Integer> list,Function<Integer,Apple> funApp){
        List<Apple> apples = new ArrayList<>();
        for (Integer e : list) {
            apples.add(funApp.apply(e));
        }
        return apples;
    }

    public static Apple giveAllApple(String color,Integer weight){
        return map.get(color).apply(color,weight);
    }
}
