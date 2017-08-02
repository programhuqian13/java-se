package org.tony.java.jdk8.statement.lambda.example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanyi on 2017/8/1.
 * 应对不同的需求  --》 通过行为参数化传递代码
 */
public class Example2 {

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple(80,"green")
                                            ,new Apple(152,"red")
                                            ,new Apple(120,"red")
                                            ,new Apple(158,"green"));

        //查询所有绿色的苹果  不实用java8
        List<Apple> appleGreenList = filterGreenApple(apples);
        System.out.println(appleGreenList);

        List<Apple> appleHeavyList = filterAppleByWeight(apples,120);
        System.out.println(appleHeavyList);

        List<Apple> appleColorAndWeight = filterApples(apples,"red",0,true);
        System.out.println(appleColorAndWeight);

        List<Apple> appleColorAndWeight1 = filterApples(apples,"",150,false);
        System.out.println(appleColorAndWeight);

        //使用java8   行为参数
        List<Apple> javaGreenApple = filter(apples,new AppleFilterGreenPredicate());
        System.out.println(javaGreenApple);

        List<Apple> javaWeightApple = filter(apples,new AppleFilterHeavyPredicate());
        System.out.println(javaWeightApple);

        List<Apple> javaRedAndWeightApples = filter(apples,new AppleFilterRedAndWeight());
        System.out.println(javaRedAndWeightApples);

        filterFormatter(apples,new AppleFormatterColorAndWeight());

        filterFormatter(apples,new AppleFormatterWeight());

        //上面的例子都比较啰嗦，现在我们lambda表达式进行优化
        List<Apple> lambdaApples = filter(apples,(Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(lambdaApples);



        List<Integer> lambdaApples2 = filter(Arrays.asList(1,12,5,5,2,5,2),(Integer i) -> i % 2 == 0);
        System.out.println(lambdaApples2);

        //进行相应的排序
//        apples.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
//
//        apples.sort((Apple apple1,Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));

        //Runnable执行快
        Thread t = new Thread(() -> System.out.println("Hello world!"));
        t.run();
    }

    /*****************不采用的方式 也是以前的方式******************/

    /****
     * 查询绿色的苹果
     */
    public static List<Apple> filterGreenApple(List<Apple> appleList){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : appleList){
            if("green".equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }

    /***
     * 将颜色值作为参数传递
     * @param appleList  需要检索的苹果集合
     * @param color  颜色参数
     * @return  返回检索的结果
     */
    public static List<Apple> filterColorApple(List<Apple> appleList,String color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : appleList){
            if(apple.getColor().equals(color))
                result.add(apple);
        }
        return result;
    }

    /***
     * 根据制定的重量查询
     * @param appleList 需要检索的苹果集合
     * @param weight 重量
     * @return 返回检索的结果
     */
    public static List<Apple> filterAppleByWeight(List<Apple> appleList,int weight){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : appleList){
            if(apple.getWeight() > weight)
                result.add(apple);
        }
        return result;
    }

    /***
     * 对所有属性过滤
     */
    public static List<Apple> filterApples(List<Apple> appleList,String color,int weight,boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : appleList){
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight))
                result.add(apple);
        }
        return result;
    }

    public static List<Apple> filter(List<Apple> appleList,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : appleList){
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }

    public static void filterFormatter(List<Apple> appleList,AppleFormatter appleFormatter){
        for(Apple apple : appleList){
            String out = appleFormatter.formatter(apple);
            System.out.println(out);
        }
    }

    /*****************不采用的方式 也是以前的方式******************/

    /**************************Jdk 8 的处理方式（行为参数化）************************************/
    interface ApplePredicate{

        boolean test(Apple apple);

    }

    /****
     * 通过不同的实现去检索苹果
     */
    static class AppleFilterHeavyPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return apple.getWeight() > 150;
        }
    }

    static class AppleFilterGreenPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    static class AppleFilterRedAndWeight implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    public static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list){
            if(p.test(t))
                result.add(t);
        }
        return result;
    }


    //打印相关的苹果信息
    interface AppleFormatter{
        String formatter(Apple apple);
    }

    static class AppleFormatterWeight implements AppleFormatter{

        @Override
        public String formatter(Apple apple) {
            return "this is weight " + apple.getWeight() + " g";
        }
    }

    static class AppleFormatterColorAndWeight implements AppleFormatter{

        @Override
        public String formatter(Apple apple) {
            String out = apple.getWeight() > 150 ? "heavy" : "light";
            return "this is color " + apple.getColor() + " and " + out;
        }
    }


    /***
     * 将list类型抽象化
     */
    interface Predicate<T>{
        boolean test(T t);
    }




    public static class Apple{

        Integer weight = 0;

        String color = "";

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
