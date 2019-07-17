package lection03_shapes;

public class Circle extends Shape {

    private double radius;

    public final double getRadius() {
        return this.radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * (this.getRadius() * this.getRadius()));
    }
}
