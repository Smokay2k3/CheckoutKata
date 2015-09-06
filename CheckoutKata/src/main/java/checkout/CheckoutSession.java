package checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSession {

    private static final long ITEM_A_DISCOUNT = -2000;

    private static final long ITEM_B_DISCOUNT = -1500;

    private final Map<String, List<Item>> scannedItems;

    public CheckoutSession() {
        scannedItems = new HashMap<String, List<Item>>();
    }

    public void scanItem(Item newItem) {
        List<Item> items = scannedItems.get(newItem.getSKU());

        if (items == null) {
            items = new ArrayList<Item>();
            scannedItems.put(newItem.getSKU(), items);
        }

        items.add(newItem);
    }

    public long getTotal() {
        long runningTotal = 0;

        for (List<Item> scannedItemGroup : scannedItems.values()) {
            for (Item scannedItem : scannedItemGroup) {
                runningTotal += scannedItem.getPrice();
            }
        }

        runningTotal += applyDiscounts();

        return runningTotal;
    }

    private long applyDiscounts() {
        long totalDiscounts = 0;

        // Hardcoded discount calc for Item A
        List<Item> scannedItemAGroup = scannedItems.get("A");

        if (scannedItemAGroup != null) {
            int count = scannedItemAGroup.size();
            int mod = count % 3;
            if (mod > 0) {
                count -= mod;
            }

            totalDiscounts += ((count / 3) * ITEM_A_DISCOUNT);
        }

        // Hardcoded discount calc for Item B
        List<Item> scannedItemBGroup = scannedItems.get("B");

        if (scannedItemBGroup != null) {
            int count = scannedItemBGroup.size();
            int mod = count % 2;
            if (mod > 0) {
                count -= mod;
            }

            totalDiscounts += ((count / 2) * ITEM_B_DISCOUNT);
        }

        return totalDiscounts;
    }

}
