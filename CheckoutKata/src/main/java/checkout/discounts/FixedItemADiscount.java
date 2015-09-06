package checkout.discounts;

import java.util.List;
import java.util.Map;

import checkout.Item;

public class FixedItemADiscount implements IDiscount {
    private static final long ITEM_A_DISCOUNT = -2000;

    @Override
    public long applyDiscount(Map<String, List<Item>> items) {
        List<Item> scannedItemAGroup = items.get("A");

        if (scannedItemAGroup != null) {
            int count = scannedItemAGroup.size();
            int mod = count % 3;
            if (mod > 0) {
                count -= mod;
            }

            return ((count / 3) * ITEM_A_DISCOUNT);
        }

        return 0;
    }

}
