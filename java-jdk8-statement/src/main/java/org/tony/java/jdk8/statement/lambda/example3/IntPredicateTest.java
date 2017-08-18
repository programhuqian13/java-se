package org.tony.java.jdk8.statement.lambda.example3;

import java.util.function.IntPredicate;

/**
 * Created by tony on 2017/8/18.
 * java中有装箱操作（将原始类型转换为对应的引用类型）和拆箱操作（将引用类型转换为对应的原始类型）
 * 但是java提供了自动装箱拆箱，但是这对性能的消耗会比较大：
 * 装箱后的值本质上就是把原始类型包裹起来，并保存在堆中，因此装箱后的值需要更多的内存，并需要额外的内存搜索来获取被包裹的原始值。
 */
public class IntPredicateTest {

    public static void main(String[] args) {
        IntPredicate evens = (int i) -> i % 2 == 0;
        System.out.println(evens.test(1000));
    }
}
