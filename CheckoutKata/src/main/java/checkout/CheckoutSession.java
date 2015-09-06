package checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import checkout.discounts.IDiscount;
import checkout.discounts.IDiscountProvider;
import checkout.pricing.IPriceProvider;

public class CheckoutSession {
    private final Map<String, List<Item>> scannedItems;

    private final List<IDiscount> discounts;

    /**
     * In future this should be Autowired and the data should come from a database,
     */
    private final IPriceProvider priceProvider;

    /**
     * Both IDiscount and IPrice Provider should be autowired by constructor
     */
    public CheckoutSession(IDiscountProvider discountProvider, IPriceProvider priceProvider) {
        scannedItems = new HashMap<String, List<Item>>();
        discounts = new ArrayList<IDiscount>();
        this.priceProvider = priceProvider;

        discounts.addAll(discountProvider.getAllDiscounts());
    }

    public void scanItem(String itemSKU) {
        List<Item> items = scannedItems.get(itemSKU);
        Item newItem = new Item(itemSKU, priceProvider.getPrice(itemSKU));
        
        if (items == null) {
            items = new ArrayList<Item>();
            scannedItems.put(itemSKU, items);
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
