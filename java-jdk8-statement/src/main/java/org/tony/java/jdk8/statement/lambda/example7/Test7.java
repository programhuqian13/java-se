package org.tony.java.jdk8.statement.lambda.example7;

import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by xuanyi on 2017/8/29.
 *
 * 并行数据处理和性能
 */
public class Test7 {

    static final String SENTENCE = " Nel    mezzo  del   cammin di nostra  vita" +
                            " mi ritrovai in una selva oscura " +
                            "  che la dritta via era    smarrita";

    public static long parallelSum(long n){
        return Stream.iterate(1L,i -> i+1)
                            .limit(n)
                            .parallel()  //将顺序流转换为并行流
                            .reduce(0L,Long::sum);   //将所有的数字进行归约求和
    }

    public static long measureSumPerf(Function<Long,Long> adder,long n){
        long fastest = Long.MAX_VALUE;
        for (int i = 1;i < 10;i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1000000;
            System.out.println("Result: " + sum);
            if(duration < fastest)
                fastest = duration;
        }
        return fastest;
    }

    public static void main(String[] args) {
        //将顺序流转换为并行流
        long totalParallel = parallelSum(100);
        System.out.println(totalParallel);

        //将并行流转换为顺序流用sequential()方法

        //进行性能测试  顺序流
//        System.out.println(measureSumPerf(ParallelStreams::sequentialSum,1000000) + " msecs");

        //for循环迭代
//        System.out.println(measureSumPerf(ParallelStreams::iterativeSum,1000000) + "msecs");
        //并发流 测试性能
//        System.out.println(measureSumPerf(ParallelStreams::parallelSum,1000000) + "msecs");

        System.out.println(measureSumPerf(ParallelStreams::rangedSum,1000000) + "msecs");

//        System.out.println(measureSumPerf(ParallelStreams::parallelRangedSum,1000000) + "msecs");

        //这个有问题 都不会等于500000500000  会存在竞争关系，多个程序在同时访问累加器 因为不是原子操作
//        System.out.println(measureSumPerf(ParallelStreams::sideParallelEffectSum,1000000) + "msecs");

        //分支/合并架构的测试
        System.out.println(measureSumPerf(ForkJoinSumCalculator::forkJoinSum,1000000) + "msecs");

        //一个迭代式字数统计方法
        System.out.println(countWordsIteratively(SENTENCE));

//        Stream<Character> stream  = IntStream.range(0,SENTENCE.length())
//                                            .mapToObj(SENTENCE::charAt);

//        System.out.println(counterWords(stream));  //非并行操作
        //因为原始的String在任意位置拆分，所以有时一个词会被分为两个词，然后数了两次
        //拆分流会影响结果，而把顺序流换成并行流就可能使结果出错
//        System.out.println(counterWords(stream.parallel()));  //并行操作 结果和非并行操作不一致

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream1 = StreamSupport.stream(spliterator,true);
        System.out.println(counterWords(stream1));
    }

    public static int countWordsIteratively(String s){
        int counter = 0;
        boolean lastSpace = true;
        for(char c : s.toCharArray()){
            if(Character.isWhitespace(c)){
                lastSpace = true;
            }else{
                if(lastSpace){
                    counter ++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    public static int counterWords(Stream<Character> stream){
        WordCounter wordCounter = stream.reduce(new WordCounter(0,true),
                                                WordCounter::accumulate,
                                                WordCounter::combine);
        return wordCounter.getCounter();
    }
}
