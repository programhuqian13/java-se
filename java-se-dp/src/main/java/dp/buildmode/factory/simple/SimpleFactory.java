package dp.buildmode.factory.simple;

/**
 * @ProjectName java-se
 * @PackageName dp.buildmode.factory.simple
 */
public class SimpleFactory {

    public static Product makeProduct(int kind){
        switch (kind){
            case Const.PRODUCT_1:
                return new Product1();
            case Const.PRODUCT_2:
                return new Product2();
            default:
                return null;
        }
    }
}
