package org.tony.java.jdk8.statement.lambda.example3;

/**
 * Created by tony on 2017/8/18.
 */
public class Apple {

    String name;

    int weight;

    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
