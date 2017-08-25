package org.tony.java.jdk8.statement.lambda.example4;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

/**
 * Created by xuanyi on 2017/8/24.
 * stream 综合测试
 */
public class StreamMultipleTest {

    public static Traders traders1;
    public static Traders traders2;
    public static Traders traders3;
    public static Traders traders4;

    public static List<Transaction> transactions;

    static{
        traders1 = new Traders("tony","Shanghai");
        traders2 = new Traders("zhangsan","wuhan");
        traders3 = new Traders("lisi","wuhan");
        traders4 = new Traders("wangwu","Shanghai");

        transactions = Arrays.asList(
                new Transaction(traders1,2011,300)
                ,new Transaction(traders2,2012,1000)
                ,new Transaction(traders2,2011,400)
                ,new Transaction(traders3,2012,710)
                ,new Transaction(traders3,2012,700)
                ,new Transaction(traders4,2012,950)
        );
    }

    public static void main(String[] args) {

        //找出上面数据中2011年所有交易并按交易额进行排序（从低到高）
        List<Transaction> list = transactions.stream()
                                                .filter(t -> t.getYear()==2011)
                                                .sorted(Comparator.comparing(Transaction::getValue))
                                                .collect(Collectors.toList());
        System.out.println(list);

        //交易员都在哪些城市工作
        List<String> citys = transactions.stream()
                                            .map(transaction -> transaction.getTraders().getCity())
                                            .distinct()   //这个地方可以将流转换为ser，使用toSet方法，set是不会重复的，如下
                                            .collect(Collectors.toList());
        System.out.println(citys);

        Set<String> citysSet = transactions.stream()
                .map(transaction -> transaction.getTraders().getCity())
                .collect(toSet());
        System.out.println(citysSet);

        //查看来自wuhan的交易员，并按姓名排序
        List<Traders> traders = transactions.stream()
                                            .map(Transaction::getTraders)  //从交易中提取所有的交易员
                                            .filter(t -> t.getCity().equals("wuhan"))  //查询城市在wuhan的交易员
                                            .distinct()  //去重
                                            .sorted(Comparator.comparing(Traders::getName)) //根据名字排序
                                            .collect(Collectors.toList());  //将流转换为list
        System.out.println(traders);

        //查询所有交易员的姓名字符串，按字母顺序排序
        String str = transactions.stream()
                                    .map(transaction -> transaction.getTraders().getName())
                                    .distinct()
                                    .sorted()
                                    .reduce("",(s1,s2) -> s1 + s2);
        System.out.println(str);

        //上面的一个解决方案效率不是很高，所有字符串都被反复的链接，每次迭代的时候都要建立一个新的String对象
        //更好的解决方案
        String joing = transactions.stream()
                                    .map(transaction -> transaction.getTraders().getName())
                                    .distinct()
                                    .sorted()
                                    .collect(joining());
        System.out.println(joing);

        //有没有交易员是在shanghai工作的
        boolean shanghaiBased = transactions.stream()
                                .anyMatch(transaction -> transaction.getTraders().getCity().equals("Shanghai"));
        System.out.println(shanghaiBased);

        //打印生活在shanghai所有交易员的所有交易额
        transactions.stream()
                        .filter(transaction -> (transaction.getTraders().getCity()).equals("Shanghai"))
                        .map(Transaction::getValue)
                        .forEach(System.out::println);


        //打印所有交易中，最高的交易额
        Optional<Integer> highestValue = transactions.stream()
                                                    .map(Transaction::getValue)
                                                    .reduce(Integer::max);
        System.out.println(highestValue.get());

        //打印所有交易中，交易额最小的
        Optional<Transaction> minValue = transactions.stream()
                                                    .reduce((t1,t2) ->
                                                            t1.getValue() < t2.getValue() ? t1 : t2);//通过反复的比较
        System.out.println(minValue.get());

        //查出最小的交易额的交易员  优化
        Optional<Transaction> minTran = transactions.stream()
                                                    .min(Comparator.comparing(Transaction::getValue));
        System.out.println(minTran.get());

    }
}
