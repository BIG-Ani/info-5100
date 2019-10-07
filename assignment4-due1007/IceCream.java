package assignment4;

public class IceCream extends DessertItem {
    int cost;

    public IceCream() {
    }

    public IceCream(int cost) {
        this.cost = cost;
    }

    public IceCream(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }
}
