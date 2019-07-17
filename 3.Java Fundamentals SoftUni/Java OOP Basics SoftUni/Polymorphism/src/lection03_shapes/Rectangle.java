package lection03_shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.getHeight() * 2 + this.getWidth() * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.getHeight() * this.getWidth());
    }
}
