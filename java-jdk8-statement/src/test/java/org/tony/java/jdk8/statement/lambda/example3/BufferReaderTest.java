package org.tony.java.jdk8.statement.lambda.example3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by BF100395 on 2017/8/9.
 */
public class BufferReaderTest {

    public static void main(String[] args) {
        try {
            String oneline = processFile((BufferedReader br) -> br.readLine());

            String twoline = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println(oneline);
            System.out.println(twoline);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String processFile(BufferedReaderProcessor bp) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/data.txt"));
        return bp.process(bufferedReader);
    }
}
