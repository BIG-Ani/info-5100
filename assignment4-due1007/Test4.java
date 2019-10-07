package assignment4;

public class Test4 {

    public static void main(String[] args) {
        /*Shape s = new Shape();
        Rectangle rectangle = new Rectangle(2.0, 3.0);
        Circle circle = new Circle(4.0);
        Square square = new Square(4.0);

        rectangle.getArea();
        rectangle.getPerimeter();

        circle.getArea();
        circle.getPerimeter();

        square.getArea();
        square.getPerimeter();

        s.draw();
        rectangle.draw();
        circle.draw();
        square.draw();*/

        /*Psychiatrist psychiatrist = new Psychiatrist();
        SadObject sadObject = new SadObject();
        HappyObject happyObject = new HappyObject();

        psychiatrist.examine(sadObject);
        psychiatrist.observe(sadObject);

        System.out.println();

        psychiatrist.examine(happyObject);
        psychiatrist.observe(happyObject);*/

        CheckOut checkOut = new CheckOut();
        checkOut.enterItems(new Candy("peanut butter fudge", 2.25, 399));
        checkOut.enterItems(new IceCream("Vanilla Ice Cream", 105));
        checkOut.enterItems(new Sundae("Choc. Chip Ice Cream", 145, "Hot fudge", 50));
        checkOut.enterItems(new Cookie("Oatmeal Raisin Cookies", 4, 399));

        System.out.println("\nNumber of items : " + checkOut.numberOfItems());
        int totalCost = checkOut.totalCost();
        System.out.println("\nTotal Cost : " + totalCost);
        int totalTax = checkOut.totalTax();
        System.out.println("\nTotal tax : " + totalTax);
        System.out.println("\nCost + Tax: " + (totalCost + totalTax) + "\n");

        System.out.println(checkOut);
    }

}
