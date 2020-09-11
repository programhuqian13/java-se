package principle.dip;

public class Customer {

    public String shopping(Shop shop){
        return shop.sell();
    }

}
