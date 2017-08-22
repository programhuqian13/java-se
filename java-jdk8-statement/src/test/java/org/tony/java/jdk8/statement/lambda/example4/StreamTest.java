package org.tony.java.jdk8.statement.lambda.example4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by tony on 2017/8/21.
 * steam api 使用1   筛选
 */
public class StreamTest {

    public static void main(String[] args) {

        List<Dish> list = Arrays.asList(new Dish("红烧鱼",false,300,Dish.Type.FISH),
                                        new Dish("aaaa",true,400,Dish.Type.MEAT),
                                        new Dish("bbbb",false,350,Dish.Type.OTHER),
                                        new Dish("cccc",true,200,Dish.Type.MEAT),
                                        new Dish("dddd",false,200,Dish.Type.FISH),
                                        new Dish("eeee",true,500,Dish.Type.OTHER));

        List<String> threeHeightCaloricDishName = list.stream() //从list中获得菜肴流  建立流水线
                                                    .filter(d ->d.getCalories() > 300)  //首先选择高热量的菜肴
                                                    .map(Dish::getName)  //得到列表中的名称
                                                    .limit(3) //选出前三个  截短操作
                                                    .collect(toList());  //将结果存在另一个List中
        System.out.println(threeHeightCaloricDishName);
        //使用谓词筛选 fiter方法接受一个谓词（返回boolean函数）作为参数，并返回一个包括所有复合谓词的元素的流
        List<Dish> listFiter = list.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(listFiter);

        //distinct方法是返回一个元素的各异，并且不会重复
        List<Integer> numbers = Arrays.asList(2,12,1,33,3,3,5,4,1,2);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        //skip()方法返回一个扔掉了前N个元素的流，如果流中的元素不足n个，就返回一个空流。
        List<Dish> listSkip = list.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
        System.out.println(listSkip);


    }
}
