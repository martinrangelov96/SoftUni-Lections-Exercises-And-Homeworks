package lection06_stackOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stack = new StackOfStrings();

        stack.push("pesho");
        stack.push("pesho0");
        stack.push("pesho1");
        stack.push("pesho2");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
