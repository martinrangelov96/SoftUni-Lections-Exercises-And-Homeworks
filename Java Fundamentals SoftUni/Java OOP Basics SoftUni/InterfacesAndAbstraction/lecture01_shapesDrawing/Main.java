package lecture01_shapesDrawing;

public class Main {
    public static void main(String[] args) {

        Drawable circle = new Circle(5);
        circle.draw();
        Drawable rect = new Rectangle(10,20);
        rect.draw();

    }
}
