package lection03_scale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(5, 5);

        System.out.println(scale.getHeavier());
    }
}
