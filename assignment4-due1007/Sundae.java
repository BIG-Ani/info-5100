package assignment4;

public class Sundae extends IceCream {
    String toppingName;
    int toppingCost;

    public Sundae() {
    }

    public Sundae(String name, int cost, String toppingName, int toppingCost) {
        super(name, cost);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    @Override
    public int getCost() {
        return cost + toppingCost;
    }

    @Override
    public String toString() {
        return toppingName + " with " + name;
    }
}
