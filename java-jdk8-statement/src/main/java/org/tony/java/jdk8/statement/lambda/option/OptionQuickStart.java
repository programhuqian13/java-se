package org.tony.java.jdk8.statement.lambda.option;

import jdk.nashorn.internal.runtime.options.Option;
import org.tony.java.jdk8.statement.lambda.option.example1.Car;
import org.tony.java.jdk8.statement.lambda.option.example1.Insurance;
import org.tony.java.jdk8.statement.lambda.option.example1.Person;

import java.util.Optional;

/**
 * @Date 2018/6/14
 * @ProjectName java-se
 * @PackageName org.tony.java.jdk8.statement.lambda.option
 */
public class OptionQuickStart {

    public static void main(String[] args) {
        //创建一个空的optional
        Optional<Car> optionalCarEmpty = Optional.empty();
        Car car = new Car();
        //创建一个得空的Optional
        //如果car是一个null，这段代码会立即抛出一个空指针异常，而不是试图等你访问car的属性是才返回一个错误。
        Optional<Car> optionalNoEmpty = Optional.of(car);
        //可接受null的optional
        Optional<Car> optionalCarResiveNo = Optional.ofNullable(car);
        Person person = new Person();
        person.setCar(optionalNoEmpty);
        //使用map从Optional对象中提取和转换值
        Insurance insurance = new Insurance();
        Optional<Insurance> insuranceOptional = Optional.ofNullable(insurance);
        Optional<String> name = insuranceOptional.map(Insurance::getName);
        System.out.println(name);  //Optional.empty

        //使用flatMap链接Optional对象
        //jdk 8以前的代码如下
        //public String getCarInsuranceName(Person person) {
        //return person.getCar().getInsurance().getName();
        //}
        //jdk8optional对象代码样式
        Optional<Person> optionalPerson = Optional.of(person);
        String namestr = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unkwon");
        System.out.println(namestr);

        //使用optional解引用串接的person、car、insurance对象

    }
}
