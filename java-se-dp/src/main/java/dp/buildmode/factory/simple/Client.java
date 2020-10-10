package dp.buildmode.factory.simple;

/**
 * @Description 简单工厂模式
 * @ProjectName java-se
 * @PackageName dp.buildmode.factory.simple
 */
public class Client {

    public static void main(String ... args){
        Product product = SimpleFactory.makeProduct(0);
        product.show();
        Product product1 = SimpleFactory.makeProduct(1);
        product1.show();
    }

}
