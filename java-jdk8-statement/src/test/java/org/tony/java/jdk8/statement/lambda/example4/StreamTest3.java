package org.tony.java.jdk8.statement.lambda.example4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by tony on 2017/8/22.
 * stream映射
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<Dish> list = Arrays.asList(new Dish("红烧鱼",false,300,Dish.Type.FISH),
                new Dish("aaaa",true,400,Dish.Type.MEAT),
                new Dish("bbbb",false,350,Dish.Type.OTHER),
                new Dish("cccc",true,200,Dish.Type.MEAT),
                new Dish("dddd",false,200,Dish.Type.FISH),
                new Dish("eeee",true,500,Dish.Type.OTHER));

        //map()方法，会接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<Integer> dishNames = list.stream().map(Dish::getName).map(String::length).distinct().collect(toList());
        System.out.println(dishNames);

        List<String> listStrs = Arrays.asList("java8","lambda","in","action");
        List<Integer> listInte = listStrs.stream().map(String::length).collect(toList());
        System.out.println(listInte);

        //flatMap方法的效果是各个数组并不是分别映射成一个流，而是映射成流的内容。所有用map(Arrays::stream)时生成的单个流都被合并起来，及扁平化为一个流
        //把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
        List<String> words = Arrays.asList("Goodbye","World");
        List<String> uniqueChar = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(uniqueChar);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> result = numbers.stream().map(i -> i*i).collect(toList());
        System.out.println(result);

        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(1,2);
        List<int []> paris = numbers1.stream()
                                .flatMap(i -> numbers2.stream()
                                                .map(j -> new int[]{i,j})
                                )
                                .collect(toList());
        System.out.println(paris);

        List<Integer> numbers3 = Arrays.asList(1, 2, 3);
        List<Integer> numbers4 = Arrays.asList(3, 4);
        List<int[]> pairs1 =
                numbers3.stream()
                        .flatMap(i ->
                                numbers4.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        System.out.println(pairs1);

        //anyMatch()方法查询是否有一个元素能匹配给定的谓词
        if(list.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!");
        }

        //allMatch()方法查询能够所有元素是否匹配指定的谓词
        if(list.stream().allMatch(d -> d.getCalories() > 300)){
            System.out.println("The menu is (somewhat) vegetarian heat!");
        }

        //noneMatch()方法确定没有任何一个元素匹配给定的谓词
        if(list.stream().noneMatch(d -> d.getCalories() > 300)){
            System.out.println("The menu is (somewhat) vegetarian nonematch!");
        }

        //查找元素 findAny()方法将返回当前流中的任意元素。他可以和其他流操作结合使用
        Optional<Dish> dish = list.stream().filter(Dish::isVegetarian).findAny();

    }

}
