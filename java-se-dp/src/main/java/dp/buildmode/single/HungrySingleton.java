package dp.buildmode.single;

/***
 * 饿汉式单例
 * 类一旦加载就创建一个单例，保证在调用的时候对象已经存在了
 * 类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变了。是线程安全的
 * 可以直接用于多线程而不会出现线程安全问题
 */
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }

}
