package org.tony.java.jdk8.statement.lambda.example4;

/**
 * Created by xuanyi on 2017/8/24.
 */
public class Traders {

    private final String name;

    private final String city;

    public Traders(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Traders{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
