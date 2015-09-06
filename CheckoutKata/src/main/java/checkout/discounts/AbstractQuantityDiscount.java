package checkout.discounts;

import java.util.List;
import java.util.Map;

import checkout.Item;

/**
 * Abstract class allowing quantity discounts to be applied. 
 * 
 * @author timp
 *
 */
public abstract class AbstractQuantityDiscount implements IDiscount {
    
    @Override
    public long applyDiscount(Map<String, List<Item>> items) {
        List<Item> scannedItemAGroup = items.get(getApplicableSKU());

        if (scannedItemAGroup != null) {
            int count = scannedItemAGroup.size();
            int mod = count % getItemCount();
            if (mod > 0) {
                count -= mod;
            }

            return ((count / getItemCount()) * getDiscount());
        }

        return 0;
    }

    protected abstract int getItemCount();

}
