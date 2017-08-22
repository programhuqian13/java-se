package org.tony.java.jdk8.statement.lambda.example3.sort.one;

import org.tony.java.jdk8.statement.lambda.example3.sort.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

/**
 * Created by tony on 2017/8/21.
 */
public class TestMethodReference {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green",150)
                                        ,new Apple("red",160)
                                        ,new Apple("green",152)
                                        ,new Apple("blue",152)
                                        ,new Apple("red",85));
        list.sort(comparing(Apple::getWeight));
        System.out.println(list);

        //下面是lambda复合
        list.sort(comparing(Apple::getWeight).reversed());
        System.out.println(list);

        //先按重量排序 再按color排序
        list.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor));
        System.out.println(list);

        //函数复合:Function 接口代表的lambda表达式复合起来，function接口为此配了andThen和Compose两个默认方法，会返回function的一个实例。
        //andThen方法会返回一个函数，他先对输入应用一个给定函数，在对输出应用另一个函数。
        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> g = x -> x * 2;
        Function<Integer,Integer> h = f.andThen(g);
        System.out.println(h.apply(1));

        //compose方法先把给定的函数用作compose的参数里面给的那个函数，然后在把函数本身用于结果
        Function<Integer,Integer> f1 = x -> x + 1;
        Function<Integer,Integer> g1 = x -> x * 2;
        Function<Integer,Integer> h1 = f1.compose(g1);
        System.out.println(h1.apply(1));
    }
}
