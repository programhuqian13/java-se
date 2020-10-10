package dp.buildmode.factory.factorymethod;

/**
 * @ProjectName java-se
 * @PackageName dp.buildmode.factory.factory
 */
public class ConCreateFactory2 extends AbstractFactory {
    @Override
    Product newProduct() {
        return new ConCreateProduct2();
    }
}
