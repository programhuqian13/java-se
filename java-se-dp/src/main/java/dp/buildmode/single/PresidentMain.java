package dp.buildmode.single;


import java.util.Objects;

public class PresidentMain {

    public static void main(String[] args) {
        President president = President.getInstance();
        System.out.println(president.getName());
        President president1 = President.getInstance();
        System.out.println(president1.getName());
        if(Objects.equals(president,president1)){
            System.out.println("为同一个人");
        }else{
            System.out.println("不是同一个人");
        }
    }

}
