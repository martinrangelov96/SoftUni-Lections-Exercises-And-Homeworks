package lection06and07_genericFlatMethodAndAddAllMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<?> list;

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 5.5, 6.7);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, ints, doubles);

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, jagged);
        ListUtils.addAll(dest, doubles);
    }
}
