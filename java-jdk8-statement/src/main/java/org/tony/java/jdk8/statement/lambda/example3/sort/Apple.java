package org.tony.java.jdk8.statement.lambda.example3.sort;

/**
 * Created by tony on 2017/8/21.
 * sort
 */
public class Apple {

    String color;

    Integer weight;

    public Apple() {
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
