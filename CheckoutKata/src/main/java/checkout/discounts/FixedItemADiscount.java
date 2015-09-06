package checkout.discounts;

public class FixedItemADiscount extends AbstractQuantityDiscount {

    @Override
    public String getApplicableSKU() {
        return "A";
    }

    @Override
    public long getDiscount() {
        return -2000l;
    }

    @Override
    protected int getItemCount() {
        return 3;
    }

}
