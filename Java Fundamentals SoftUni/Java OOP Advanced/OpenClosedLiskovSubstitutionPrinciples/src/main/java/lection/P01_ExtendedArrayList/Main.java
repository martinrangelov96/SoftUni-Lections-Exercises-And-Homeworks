package lection.P01_ExtendedArrayList;

public class Main {
    public static void main(String[] args) {

        ExtendedArrayList<Integer> myList = new ExtendedArrayList<>() {{
            add(4);
            add(5);
            add(10);
            add(1);
        }};

        System.out.println(myList.min());
        System.out.println(myList.max());

    }
}
