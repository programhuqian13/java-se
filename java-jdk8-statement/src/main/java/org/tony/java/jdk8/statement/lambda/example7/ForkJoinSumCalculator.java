package org.tony.java.jdk8.statement.lambda.example7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by xuanyi on 2017/8/29.
 * 用分支和合并框架执行并行求和
 */
//继承RecursiveTask来创建可以用于分支/合并框架的任务
public class ForkJoinSumCalculator extends RecursiveTask<Long>{

    private final long[] numbers;  //需要求和的数组
    private final int start;  //子任务处理的数组的开始位置
    private final int end;   //子任务处理的数组的终止位置

    public static final long THRESHOLD = 10000;  //不再将任务分解为子任务的数组大小

    public ForkJoinSumCalculator(long[] numbers) {   //用于创建主任务
        this(numbers,0,numbers.length);
    }

    //s私有构造函数用于以递归方式为主任务创建子任务
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {  //负责求和的部分的大小
        int lenght = end - start;
        if(lenght <= THRESHOLD){  //当大小小于阈值 顺序计算结果
            return computeSequentially();
        }
        //创建一个子任务来为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,start +lenght / 2);
        leftTask.fork();  //利用另一个ForkJoinPool线程异步执行新创建的子任务
        //创建一个子任务来为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start +lenght / 2,end);
        Long rightResult = rightTask.compute();  //同步执行第二个子任务有可能允许进一步递归划分
        Long leftResult = leftTask.join();  //读取第一个子任务的结果，如果没有完成就等待
        return rightResult + leftResult;  //返回两个子任务结果的组合
    }

    //在子任务不能再进行划分的时候计算结果的简单方法
    private Long computeSequentially() {
        long sum = 0;
        for(int i = start;i < end;i ++){
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n){
        long [] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }


}
