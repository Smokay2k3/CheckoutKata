package checkout.discounts;

import java.util.Collection;

public interface IDiscountProvider {

    Collection<? extends IDiscount> getAllDiscounts();
}
