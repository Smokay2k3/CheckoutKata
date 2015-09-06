package checkout.discounts;

import java.util.List;
import java.util.Map;

import checkout.Item;

public interface IDiscount {

    long applyDiscount(Map<String, List<Item>> items);

}
