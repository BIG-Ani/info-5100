package assignment4;

import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    DessertShop dessertShop = new DessertShop();
    List<DessertItem> checkOutList;

    public CheckOut() {
        checkOutList = new ArrayList<DessertItem>();
    }

    // Returns the number of DessertItem's in the list
    public int numberOfItems(){
        if(checkOutList == null)
            return 0;

        return checkOutList.size();
    }

    // A DessertItem is added to the end of the list of items
    public void enterItems(DessertItem dessertItem){
        checkOutList.add(dessertItem);
    }

    // Clears the Checkout to begin checking out a new set of items
    public void clear(){
        checkOutList.clear();
    }

    // Returns total cost of items in cents (without tax)
    public int totalCost(){
        int totalCost = 0;

        for(DessertItem dessertItem : checkOutList)
            totalCost += dessertItem.getCost();

        return totalCost;
    }

    // Returns total tax on items in cents
    public int totalTax(){
        int totalTax = (int) (this.totalCost() * dessertShop.taxRate);

        return totalTax;
    }

    @Override
    public String toString() {
        String receipt = dessertShop.name + "\n" + "----------------" + "\n";

        for(DessertItem dessertItem : checkOutList){
            receipt += dessertItem.toString() + "         "
                    + dessertShop
                    .cents2dollarsAndCentsmethod(dessertItem.getCost()
            ) + "\n";
        }

        receipt += "Tax         " + dessertShop.cents2dollarsAndCentsmethod(totalTax()) + "\n";
        receipt += "Total Cost         " + dessertShop.cents2dollarsAndCentsmethod(totalCost() + totalTax()) + "\n";

        return receipt;
    }
}
