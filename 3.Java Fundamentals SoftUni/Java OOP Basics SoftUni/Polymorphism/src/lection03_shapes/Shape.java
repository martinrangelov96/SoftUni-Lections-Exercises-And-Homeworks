package lection03_shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public double getArea() {
        return this.area;
    }

    public abstract void calculatePerimeter();
    public abstract void calculateArea();


}
