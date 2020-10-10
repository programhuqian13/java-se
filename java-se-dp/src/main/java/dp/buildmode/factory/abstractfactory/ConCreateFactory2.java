package dp.buildmode.factory.abstractfactory;

/**
 * @ProjectName java-se
 * @PackageName dp.buildmode.factory.abstractfactory
 */
public class ConCreateFactory2 extends AbstractFactory{

    @Override
    Product1 newProduct1() {
        System.out.println("生产对象1");
        return new ConCreateProduct12();
    }

    @Override
    Product2 newProduct2() {
        System.out.println("生产对象1-2");
        return new ConCreateProduct2();
    }
}
