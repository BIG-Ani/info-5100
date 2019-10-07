package assignment4;

public class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + this.getClass().getName());
    }

    @Override
    public void getArea() {
        System.out.println(width * height);
    }

    @Override
    public void getPerimeter() {
        System.out.println(2 * (width + height));
    }
}
