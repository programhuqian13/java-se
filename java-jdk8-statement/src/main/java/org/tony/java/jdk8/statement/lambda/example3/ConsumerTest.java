package org.tony.java.jdk8.statement.lambda.example3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by tony on 2017/8/17.
 * java.util.function.Consumer;
 * 定义了一个名叫accept的抽象方法，他接受一个泛型T的对象，没有返回值。如果你需要访问类型T的对象，并对其
 * 执行某些操作，就可以使用这个接口。
 */
public class ConsumerTest {
    public static void main(String[] args) {
       forEach(Arrays.asList(1,2,3,4,5),(Integer i) -> System.out.println(i));
    }
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T t:list){
            c.accept(t);
        }
    }
}
