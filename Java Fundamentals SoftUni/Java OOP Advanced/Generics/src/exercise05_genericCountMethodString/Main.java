package exercise05_genericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countBoxes = Integer.parseInt(reader.readLine());

        List<ComparableBox<String>> boxes = new ArrayList<>();

        while (countBoxes-- > 0) {
            String input = reader.readLine();

            ComparableBox<String> box = new ComparableBox<>();
            box.setValue(input);
            boxes.add(box);

        }

        ComparableBox<String> box = new ComparableBox<>();
        box.setValue(reader.readLine());

        System.out.println(getCountOfGreaterElements(boxes, box));
    }

    private static <T extends Comparable<T>> int getCountOfGreaterElements
            (List<ComparableBox<T>> elements, ComparableBox<T> singleElement) {
        return elements
                .stream()
                .filter(element -> element.compareTo(singleElement) > 0)
                .collect(Collectors.toList())
                .size();
    }
}
