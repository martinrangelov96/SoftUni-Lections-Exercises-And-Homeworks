package lection03_shapes;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(2.45);
        Shape rect = new Rectangle(5,10);

        circle.calculatePerimeter();
        System.out.println(circle.getPerimeter());

        rect.calculatePerimeter();
        System.out.println(rect.getPerimeter());

    }
}
