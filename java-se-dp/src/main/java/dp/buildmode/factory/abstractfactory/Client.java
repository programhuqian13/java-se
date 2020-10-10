package dp.buildmode.factory.abstractfactory;

/**
 * @ProjectName java-se
 * @PackageName dp.buildmode.factory.abstractfactory
 */
public class Client {

    public static void main(String ... args){
        AbstractFactory abstractFactory = new ConCreateFactory1();
        Product1 product1 = abstractFactory.newProduct1();
        Product2 product2 = abstractFactory.newProduct2();
        product1.show();
        product2.show();

        AbstractFactory abstractFactory1 = new ConCreateFactory2();
        Product1 product11 = abstractFactory1.newProduct1();
        Product2 product21 = abstractFactory1.newProduct2();
        product11.show();
        product21.show();
    }

}
