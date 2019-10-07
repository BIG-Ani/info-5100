package assignment4;

import java.math.BigDecimal;

public class Candy extends DessertItem {
    double weight;
    int pricePerBound;

    public Candy(){}

    public Candy(double weight, int price) {
        this.weight = weight;
        this.pricePerBound = price;
    }

    public Candy(String name, double weight, int price) {
        super(name);
        this.weight = weight;
        this.pricePerBound = price;
    }

    @Override
    public int getCost() {
        return new BigDecimal(weight * pricePerBound).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    @Override
    public String toString() {
        return weight + "lbs. @ " + (pricePerBound / 100.0) + " /lb." + "\n" + name;
    }
}
