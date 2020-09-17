package dp.buildmode.single;

import java.util.Objects;

/***
 * 单例模式之懒汉式单例
 * 如果编写多线程程序，不要删除synchronized和volatile关键字
 * 删除之后会出现线程安全问题，如果不删除这两个关键字就能保证线程安全问题
 * 但是每次访问时都要同步，会影响性能，且消耗资源
 */
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        if(Objects.isNull(instance)){
            instance = new LazySingleton();
        }
        return instance;
    }

}
