package lection02_genericArrayCreator;

public class Main {
    public static void main(String[] args) {

        String[] arr = ArrayCreator.create(String.class ,10, "stringa");

        for (String s : arr) {
            System.out.println(s);
        }

    }
}
