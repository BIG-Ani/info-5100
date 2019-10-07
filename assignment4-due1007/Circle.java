package assignment4;

public class Circle extends Shape {
    double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + this.getClass().getName());
    }

    @Override
    public void getArea() {
        System.out.println(radius * radius * Math.PI);
    }

    @Override
    public void getPerimeter() {
        System.out.println(2 * Math.PI * radius);
    }
}
