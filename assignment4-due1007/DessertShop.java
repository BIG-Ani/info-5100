package assignment4;

import java.math.BigDecimal;

public class DessertShop {

    String name = "Z & Z Dessert Shop";
    double taxRate = 0.065;

    public double cents2dollarsAndCentsmethod(int cost){
        BigDecimal bigDecimal = new BigDecimal(cost / 100.0);
        double dollarCost = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return dollarCost;
    }

}
