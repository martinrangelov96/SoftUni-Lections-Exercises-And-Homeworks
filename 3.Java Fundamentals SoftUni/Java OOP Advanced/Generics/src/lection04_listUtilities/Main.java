package lection04_listUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() {{add(5); add(6); add(10);}};

        System.out.println(ListUtils.getMax(list));
        System.out.println(ListUtils.getMin(list));
    }
}
