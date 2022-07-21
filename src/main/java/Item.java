import java.math.BigDecimal;

public enum Item {
    BANANA(BigDecimal.valueOf(0.10)),
    CARROT(BigDecimal.valueOf(0.5)),
    PINEAPPLE(BigDecimal.valueOf(1.5)),
    NOODLES(BigDecimal.valueOf(0.23)),
    STRAWBERRY(BigDecimal.valueOf(0.05));

    public final BigDecimal price;
    Item(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice(){
        return price;
    }
}
