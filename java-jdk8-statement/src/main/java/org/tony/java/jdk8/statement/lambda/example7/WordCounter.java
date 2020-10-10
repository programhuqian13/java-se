package org.tony.java.jdk8.statement.lambda.example7;

/**
 */
public class WordCounter {

    private final int counter;

    private final boolean lastSpace;

    public WordCounter(int counter,boolean lastSpace){
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    //和迭代算法一样，一个个遍历Character
    public WordCounter accumulate(Character c){
        if(Character.isWhitespace(c)){
            return lastSpace ? this : new WordCounter(counter,true);
        }else{
            return lastSpace ? new WordCounter(counter + 1,false) : this;
        }
    }

    //合并两个WordCounter，把其计数器加起来
    public WordCounter combine(WordCounter wordCounter){
        //仅需要计数器的总和，无需关心lastSpace
        return new WordCounter(counter + wordCounter.counter,
                wordCounter.lastSpace);
    }

    public int getCounter(){
        return counter;
    }
}
