package principle.dip;

public class ShopMain {

    public static void main(String[] args) {
        Shop shop = new WuhanShop();
        Shop shop1 = new ShanghaiShop();

        Customer customer = new Customer();
        System.out.println(customer.shopping(shop));
        System.out.println(customer.shopping(shop1));
    }

}
