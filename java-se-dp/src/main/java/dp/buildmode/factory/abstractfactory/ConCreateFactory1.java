package dp.buildmode.factory.abstractfactory;

/**
 * @ProjectName java-se
 * @PackageName dp.buildmode.factory.abstractfactory
 */
public class ConCreateFactory1 extends AbstractFactory{

    @Override
    Product1 newProduct1() {
        System.out.println("生成对象1");
        return new ConCreateProduct12();
    }

    @Override
    Product2 newProduct2() {
        System.out.println("生产对象2-2");
        return new ConCreateProduct21();
    }
}
