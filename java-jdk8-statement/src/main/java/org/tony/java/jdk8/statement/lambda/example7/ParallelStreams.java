package org.tony.java.jdk8.statement.lambda.example7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by xuanyi on 2017/8/29.
 */
public class ParallelStreams{

    //迭代  性能最高，因为更底层，并且没有装箱拆箱的操作
    public static long iterativeSum(long n){
        long result = 0L;
        for(long i = 0L; i < n; i ++ )
            result += i;
        return result;
    }

    //顺序流
    public static long sequentialSum(long n){
       return Stream.iterate(1L,i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    //并行版本
    public static long parallelSum(long n){
        return Stream.iterate(1L,i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    //相关类型的顺序流
    public static long rangedSum(long n){
        return LongStream.rangeClosed(1,n)
                            .reduce(0L,Long::sum);
    }

    //相关类型的并行流
    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    public static long sideEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).forEach(accumulator::add);
        return accumulator.total;
    }

    //并行
    public static long sideParallelEffectSum(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
}
