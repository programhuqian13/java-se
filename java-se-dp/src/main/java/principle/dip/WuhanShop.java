package principle.dip;

public class WuhanShop implements Shop{
    @Override
    public String sell() {
        return "热干面，莲藕";
    }
}
