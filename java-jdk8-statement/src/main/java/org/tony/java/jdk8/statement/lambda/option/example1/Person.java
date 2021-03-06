package org.tony.java.jdk8.statement.lambda.option.example1;

import java.util.Optional;

/**
 * @Date 2018/6/14
 * @ProjectName java-se
 * @PackageName org.tony.java.jdk8.statement.lambda.option.example1
 */
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
