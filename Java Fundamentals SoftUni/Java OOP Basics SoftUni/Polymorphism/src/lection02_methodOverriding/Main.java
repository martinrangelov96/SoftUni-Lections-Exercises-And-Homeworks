package lection02_methodOverriding;

public class Main {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(5,10);
        Rectangle square = new Square(10);


        System.out.println(rect.area());
        System.out.println(square.area());

    }
}
