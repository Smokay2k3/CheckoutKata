package checkout;

import java.util.ArrayList;
import java.util.List;

public class CheckoutSession {

    private final List<Item> items;

    public CheckoutSession() {
        items = new ArrayList<Item>();
    }

    public void scanItem(Item product) {
        items.add(product);
    }

    public long getTotal() {
        long runningTotal = 0;

        for (Item product : items) {
            runningTotal += product.getPrice();
        }

        return runningTotal;
    }

}
