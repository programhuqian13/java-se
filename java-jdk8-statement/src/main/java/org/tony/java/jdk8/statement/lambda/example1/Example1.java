package org.tony.java.jdk8.statement.lambda.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        //不实用jdk8的情况下  查询颜色为绿色的苹果
        List<Apple> list = filterGreenApples(appleList);
        for(Apple app : list)
            System.out.println(app.toString());

    }

    public static List<Apple> filterGreenApples(List<Apple> apples){
        List<Apple> appleList = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if("green".equals(apple.getColor()))
                appleList.add(apple);
        }
        return appleList;
    }

    public static List<Apple> filterHeavyApple(List<Apple> apples){
        List<Apple> appleList = new ArrayList<Apple>();
        for(Apple apple : apples){
            if(apple.getWeight() > 150)
                appleList.add(apple);
        }
        return appleList;
    }


    /***
     * 进行判断苹果的颜色是否为绿色
     * @param apple 需要判断的苹果
     * @return 返回结果（boolean）
     */
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    /***
     * 判断苹果的重量是否大于150
     * @param apple 需要判断的苹果
     * @return  返回对比的结果
     */
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
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
