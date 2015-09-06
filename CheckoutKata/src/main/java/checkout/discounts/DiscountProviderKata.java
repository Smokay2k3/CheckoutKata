package checkout.discounts;

import java.util.Arrays;
import java.util.Collection;

public class DiscountProviderKata implements IDiscountProvider {

    @Override
    public Collection<? extends IDiscount> getAllDiscounts() {
        return Arrays.asList(new FixedItemADiscount(), new FixedItemBDiscount());
    }

}
