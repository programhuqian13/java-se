package org.tony.java.jdk8.statement.lambda.example4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by xuanyi on 2017/8/25.
 * 创建流
 */
public class CreateStreamTest {

    public static void main(String[] args) {
        //由值创建流  使用Stream.of创建一个流   可以接受任意数量的参数
        Stream<String> stringStream = Stream.of("java","leambda","in","action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);
        //创建一个空流
        Stream<String> empty = Stream.empty();

        //由数组创建流
        int [] number = {1,2,3,4,5,6};
        int sum = Arrays.stream(number).sum();
        System.out.println(sum);

        //由文件生成流
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("D://data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                                .distinct()
                                .count();
            System.out.println(uniqueWords);
        }catch (IOException e){
          e.printStackTrace();
        }

        //由函数生成流：创建无限流
        //创建流有两个方法:1.Stream.iterate()   2.Stream.genetate
        //迭代  iterate接受一个初始值，这里为0，还有一个一次应用在每个产生新的值上的lambda
        Stream.iterate(0,n -> n + 2)
                        .limit(10)
                        .forEach(System.out::println);

        //利用iterate创建斐波那契数列
        Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[0] + t[1]})
                .limit(20)
                .forEach(t ->System.out.println(t[0] + "," + t[1]));

        Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);

        //生成genetate方法不是依次对每个新生成的值应用函数的，他接受一个Supplier<T>类型的lambda提供新的值
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int next = this.previous +this.current;
                this.previous = this.current;
                this.current = next;
                return oldPrevious;
            }
        };

        IntStream.generate(fib).limit(5).forEach(System.out::println);

    }

}
