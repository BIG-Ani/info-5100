package assignment4;

import java.math.BigDecimal;

public class Cookie extends DessertItem {
    int number;
    int pricePeiDozen;

    public Cookie(){}

    public Cookie(int number, int pricePeiDozen) {
        this.number = number;
        this.pricePeiDozen = pricePeiDozen;
    }

    public Cookie(String name, int number, int pricePeiDozen) {
        super(name);
        this.number = number;
        this.pricePeiDozen = pricePeiDozen;
    }

    @Override
    public int getCost() {
        return new BigDecimal(number * pricePeiDozen / 12.0).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    @Override
    public String toString() {
        return name;
    }
}
