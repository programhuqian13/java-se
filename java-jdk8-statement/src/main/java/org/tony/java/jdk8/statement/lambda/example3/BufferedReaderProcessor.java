package org.tony.java.jdk8.statement.lambda.example3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by tony on 2017/8/9.
 */
@FunctionalInterface    //申明为函数式接口
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;

}
