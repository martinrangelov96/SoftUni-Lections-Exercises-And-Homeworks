package exercise09_linkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedList list = new LinkedList();
        int numberOfInputs = Integer.parseInt(reader.readLine());

        while (numberOfInputs-- > 0) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            int number = Integer.parseInt(input[1]);

            switch (command) {
                case "Add":
                    list.add(number);
                    break;
                case "Remove":
                    list.remove(number);
                    break;
            }
        }

        System.out.println(list.sizeCounter);
        for(Node node : list) {
            System.out.print(node.getData() + " ");
        }

    }
}
