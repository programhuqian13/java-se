package dp.buildmode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * 单例模式的扩展为有限的多例模式
 */
public class Multitcm {

    private static List<Multitcm> list = new ArrayList<>();

    private static int n = 0;

    static {
        for(int i = 0;i< n;i++){
            list.add(new Multitcm(i));
        }
    }

    public Multitcm(int n){
        this.n = n;
    }

    public static Multitcm getRandomInstance(){
        int value  = (int) (Math.random() * n);
        return list.get(value);
    }

}
