package dp.buildmode.single;

import java.util.Objects;

public class President {

    private static volatile President president = null;

    private President(){
        System.out.println("当前总统");
    }

    public static synchronized President getInstance(){
        if(Objects.isNull(president)){
            president = new President();
        }else{
            System.out.println("已经有一个总统了，不能频繁更换");
        }
        return president;
    }

    public String getName(){
        return String.format("当前的总统为：%s","tony");
    }


}
