package checkout;

//Not much need for unit testing so far as we only have simple getters and setters
public class Item {

    private final String sKU;

    private final long price;

    public Item(String sKU, long price) {
        this.sKU = sKU;
        this.price = price;
    }

    public String getSKU() {
        return sKU;
    }

    public long getPrice() {
        return price;
    }
}
