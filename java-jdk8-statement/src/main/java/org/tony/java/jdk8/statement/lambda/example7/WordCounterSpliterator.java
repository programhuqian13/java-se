package org.tony.java.jdk8.statement.lambda.example7;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by xuanyi on 2017/8/29.
 * 实现自己的Spliterator
 */
public class WordCounterSpliterator implements Spliterator<Character>{

    private final String string;

    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    //处理当前的字符
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();  //如果还有字符要处理，则返回true
    }

    //将试探拆分位置设定为要解析的string的中间
    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if(currentSize < 10){
            return null;
        }
        for(int splitPos = currentSize / 2 + currentChar;
                            splitPos < string.length();splitPos++){
            if(Character.isWhitespace(string.charAt(splitPos))){
                //创建一个新的WordCounterSpliterator来解析String从开始到拆分位置的部分
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar,splitPos));
                currentChar = splitPos;  //将这个WordCounterSpliterator的起始位置设为拆分
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
