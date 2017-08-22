package org.tony.java.jdk8.statement.lambda.example3.sort.two;

/**
 * Created by tony on 2017/8/21.
 */
public class Letter {

    public static String addHeader(String text){
        return "Form Reoul, Mario and Alan : " + text;
    }

    public static String addFooter(String text){
        return text + "Kind regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("labda","lambda");
    }
}
