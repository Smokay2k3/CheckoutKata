package checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import checkout.discounts.DiscountProviderKata;
import checkout.discounts.IDiscount;
import checkout.discounts.IDiscountProvider;

public class CheckoutSession {
    private final Map<String, List<Item>> scannedItems;

    private final List<IDiscount> discounts;

    /**
     * In future should be Autowired
     */
    private IDiscountProvider discountProvider = new DiscountProviderKata();

    public CheckoutSession() {
        scannedItems = new HashMap<String, List<Item>>();
        discounts = new ArrayList<IDiscount>();

        discounts.addAll(discountProvider.getAllDiscounts());
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

        for (IDiscount discount : discounts) {
            totalDiscounts += discount.applyDiscount(scannedItems);
        }

        return totalDiscounts;
    }

    /**
     * For testing purposes
     * 
     * @param discount
     */
    void addDiscount(IDiscount discount) {
        discounts.add(discount);
    }
}
