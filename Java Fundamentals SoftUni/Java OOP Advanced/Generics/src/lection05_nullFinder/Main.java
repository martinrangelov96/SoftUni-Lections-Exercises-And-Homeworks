package lection05_nullFinder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<?> list;

        List<String> numbers = new ArrayList<>();
        numbers.add(null);
        numbers.add("asdasd");
        numbers.add(null);

        System.out.println(ListUtils.getNullIndices(numbers));
    }
}
