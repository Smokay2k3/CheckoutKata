package checkout.pricing;

import java.util.HashMap;
import java.util.Map;

public class PriceProviderKata implements IPriceProvider {

    private Map<String, Long> sKUToPrice = new HashMap<String, Long>();

    public PriceProviderKata() {
        sKUToPrice.put("A", 5000l);
        sKUToPrice.put("B", 3000l);
        sKUToPrice.put("C", 2000l);
        sKUToPrice.put("D", 1500l);
    }

    @Override
    public long getPrice(String sKU) {
        return sKUToPrice.get(sKU);
    }

}
