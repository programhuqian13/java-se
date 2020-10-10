package org.tony.java.jdk8.statement.lambda.option.example1;

import java.util.Optional;

/**
 * @Date 2018/6/14
 * @ProjectName java-se
 * @PackageName org.tony.java.jdk8.statement.lambda.option.example1
 */
public class Car {

    //optional接口是一个操作可以为空的的值，避免报控制住异常
    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    private Optional<Insurance> insurance;

}
