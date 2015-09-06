package checkout.discounts;

public class FixedItemBDiscount extends AbstractQuantityDiscount {

    @Override
    public String getApplicableSKU() {
        return "B";
    }

    @Override
    public long getDiscount() {
        return -1500l;
    }

    @Override
    protected int getItemCount() {
        return 2;
    }

}
