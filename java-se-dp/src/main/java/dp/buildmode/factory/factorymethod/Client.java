package dp.buildmode.factory.factorymethod;

/**
 * @ProjectName java-se
 * @PackageName dp.buildmode.factory.factory
 */
public class Client {

    public static void main(String ... args){
        AbstractFactory abstractFactory = new ConCreateFactory1();
        Product product = abstractFactory.newProduct();
        product.show();
    }

}
