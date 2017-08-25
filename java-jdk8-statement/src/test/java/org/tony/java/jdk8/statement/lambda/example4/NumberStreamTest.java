package org.tony.java.jdk8.statement.lambda.example4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by xuanyi on 2017/8/25.
 * 映射为数值流
 */
public class NumberStreamTest {

    static final List<Dish> list;

    static{
        list = Arrays.asList(new Dish("红烧鱼",false,300,Dish.Type.FISH),
                new Dish("aaaa",true,400,Dish.Type.MEAT),
                new Dish("bbbb",false,350,Dish.Type.OTHER),
                new Dish("cccc",true,200,Dish.Type.MEAT),
                new Dish("dddd",false,200,Dish.Type.FISH),
                new Dish("eeee",true,500,Dish.Type.OTHER));
    }

    public static void main(String[] args) {
        //将流映射为数值流,将流转换为特化版本的常见方法是：mapToInt,mapToDouble和mapToLong
        //这些方法会返回一个特化流
        int calories = list.stream()   //返回一个stream<Dish>
                            .mapToInt(Dish::getCalories) //返回一个IntStream流
                            .sum();
        System.out.println(calories);

        //转换为对象流
        IntStream intStream = list.stream()
                                    .mapToInt(Dish::getCalories);  //得到一个intstream流
        Stream<Integer> stream = intStream.boxed();  //将数值流转换为stream

        //默认值OptionalInt
        OptionalInt max = list.stream()
                                .mapToInt(Dish::getCalories)
                                .max();
        int maxValue = max.orElse(1);
        System.out.println(maxValue);

        //数值范围  有两个方法：1，rangeClosed() 包含结束值  2.range()不包含结束值
        IntStream evenNumbers = IntStream.rangeClosed(1,100)
                                            .filter(i -> i % 2 ==0);
        System.out.println(evenNumbers.count());

        //勾股定理（三元数）
        Stream<int []> pythagoreanTriples = IntStream.rangeClosed(1,100).boxed()  //boxed将数值流转换为对象流
                                                        .flatMap(a ->   //flatMap 扁平化流操作
                                                                    IntStream.rangeClosed(a,100)
                                                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)  //过滤相应的值
                                                                        .mapToObj(b ->   //mapToObj 将数值流转换为对象流
                                                                                new int[]{a,b,(int)Math.sqrt(a * a + b * b)})
                                                        );
        pythagoreanTriples.limit(10).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));

        //勾股定理更好的解决方案 先拿出所有的三元素，之后再进行筛选
        Stream<double []> py = IntStream.rangeClosed(1,100).boxed()
                                        .flatMap(a ->
                                                    IntStream.rangeClosed(a,100)
                                                                .mapToObj(b -> new double[]{a , b ,Math.sqrt(a * a + b * b)})
                                        ).filter(t -> t[2] % 1 == 0);
        py.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
    }

}
