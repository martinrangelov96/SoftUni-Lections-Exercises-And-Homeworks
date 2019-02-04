package lection05_customRandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList a1 = new RandomArrayList();

        a1.add(5);
        a1.add(15);
        a1.add(52);
        a1.add(53);

        System.out.println(a1.getRandomElement());

    }
}
