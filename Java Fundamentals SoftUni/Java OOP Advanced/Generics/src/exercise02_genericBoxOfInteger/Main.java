package exercise02_genericBoxOfInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countBoxes = Integer.parseInt(reader.readLine());

        List<Box<Integer>> boxes = new ArrayList<>();

        while (countBoxes-- > 0) {
            int input = Integer.parseInt(reader.readLine());

            Box<Integer> box = new Box<>();
            box.setValue(input);
            boxes.add(box);

        }

        boxes.forEach(System.out::println);
    }
}
