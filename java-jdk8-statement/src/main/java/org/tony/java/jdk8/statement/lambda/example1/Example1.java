package org.tony.java.jdk8.statement.lambda.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tony on 2017/7/31.
 * 让函数作为参数传递
 */
public class Example1 {

    public static void main(String[] args) {

        List<Apple> appleList = Arrays.asList(new Apple(100,"red"),
                                                new Apple(151,"green"),
                                                new Apple(120,"green"),
                                                new Apple(130,"red"));

        //不使用jdk8的情况下  查询颜色为绿色的苹果
//        List<Apple> list = filterGreenApples(appleList);
//        for(Apple app : list)
//            System.out.println(app.toString());

//        List<Apple> apples = filterHeavyApple(appleList);
//        for (Apple app: apples)
//            System.out.println(app.toString());

        //jdk 8使用example1 传递方法
//        List<Apple> isGreen = filterApples(appleList,Example1 :: isGreenApple);
//        System.out.println(isGreen);

//        List<Apple> isHeavy = filterApples(appleList,Example1 :: isHeavyApple);
//        System.out.println(isHeavy);

        //现在使用lambda表达式  传入相应的代码
        List<Apple> isGreenLambda = filterApples(appleList,(Apple a) -> "green".equals(a.getColor()));
        System.out.println("现在使用lambda表达式" + isGreenLambda);

        List<Apple> isHeavyLambda = filterApples(appleList,(Apple a) -> a.getWeight() > 150);
        System.out.println("现在使用lambda表达式" + isHeavyLambda);

        List<Apple> isHeavyAndColor = filterApples(appleList,(Apple a) ->  a.getWeight() < 80
                                                                && "blue".equals(a.getColor()));
        System.out.println("现在使用lambda表达式" + isHeavyAndColor);

        //分支处理  stream
        List<Apple> streamGreenApples = appleList.stream()
                                        .filter((Apple a) -> "green".equals(a.getColor()))
                                        .collect(Collectors.toList());

        System.out.println("分支处理  stream" + streamGreenApples);
        //并行处理
        List<Apple> pareStreamHeavyApples = appleList.parallelStream()
                                            .filter((Apple a) -> a.getWeight() > 150)
                                            .collect(Collectors.toList());
        System.out.println("并行处理  parallelStream" + pareStreamHeavyApples);
    }

    /***
     * jdk 8以前
     * @param apples  苹果集合
     * @return  返回比对的结果
     */
    public static List<Apple> filterGreenApples(List<Apple> apples){
        List<Apple> appleList = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if("green".equals(apple.getColor()))
                appleList.add(apple);
        }
        return appleList;
    }

    /***
     * jdk 8以前
     * @param apples  苹果集合
     * @return  返回比对的结果
     */
    public static List<Apple> filterHeavyApple(List<Apple> apples){
        List<Apple> appleList = new ArrayList<Apple>();
        for(Apple apple : apples){
            if(apple.getWeight() > 150)
                appleList.add(apple);
        }
        return appleList;
    }


    /***
     * jdk 8 以后
     * 进行判断苹果的颜色是否为绿色
     * @param apple 需要判断的苹果
     * @return 返回结果（boolean）
     */
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    /***
     * jdk 8 以后
     * 判断苹果的重量是否大于150
     * @param apple 需要判断的苹果
     * @return  返回对比的结果
     */
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }

    public interface Predicate<T>{
        boolean test(T t);
    }

    /***
     * jdk 8 方法作为参数传递
     * @param inventory
     * @param p
     * @return
     */
    static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> p){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory){
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }

    public static class Apple{
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

}
