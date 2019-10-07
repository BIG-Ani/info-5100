package assignment4;

public class Square extends Shape {
    double side;

    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + this.getClass().getName());
    }

    @Override
    public void getArea() {
        System.out.println(side * side);
    }

    @Override
    public void getPerimeter() {
        System.out.println(4 * side);
    }
}
