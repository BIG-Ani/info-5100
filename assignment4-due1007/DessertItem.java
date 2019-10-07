package assignment4;

abstract public class DessertItem {

    protected String name;

    public DessertItem() {
    }

    public DessertItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public int getCost();
}
