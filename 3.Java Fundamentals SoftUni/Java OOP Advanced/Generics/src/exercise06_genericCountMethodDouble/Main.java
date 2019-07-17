package exercise06_genericCountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countBoxes = Integer.parseInt(reader.readLine());

        List<ComparableBox<Double>> boxes = new ArrayList<>();

        while (countBoxes-- > 0) {
            Double input = Double.valueOf(reader.readLine());

            ComparableBox<Double> box = new ComparableBox<>();
            box.setValue(input);
            boxes.add(box);

        }

        ComparableBox<Double> box = new ComparableBox<>();
        box.setValue(Double.valueOf(reader.readLine()));

        System.out.println(String.format("%.0f",getCountOfGreaterElements(boxes, box)));
    }

    private static <T extends Comparable<T>> double getCountOfGreaterElements
            (List<ComparableBox<T>> elements, ComparableBox<T> singleElement) {
        return elements
                .stream()
                .filter(element -> element.compareTo(singleElement) > 0)
                .collect(Collectors.toList())
                .size();
    }
}
