package lection01_overloadMethod;

public class MathOperation {

    public int add(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    public int add(int numberOne, int numberTwo, int numberThree) {
        return numberOne + numberTwo + numberThree;
    }

    public int add(int numberOne, int numberTwo, int numberThree, int numberFour) {
        return numberOne + numberTwo + numberThree + numberFour;
    }

}
