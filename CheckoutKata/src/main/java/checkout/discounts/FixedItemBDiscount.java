package checkout.discounts;

import java.util.List;
import java.util.Map;

import checkout.Item;

public class FixedItemBDiscount implements IDiscount {
    private static final long ITEM_B_DISCOUNT = -1500;

    @Override
    public long applyDiscount(Map<String, List<Item>> items) {
        List<Item> scannedItemBGroup = items.get("B");

        if (scannedItemBGroup != null) {
            int count = scannedItemBGroup.size();
            int mod = count % 2;
            if (mod > 0) {
                count -= mod;
            }

            return ((count / 2) * ITEM_B_DISCOUNT);
        }

        return 0;
    }

}
