package exercises.exercise03_dependencyInversion.strategies;

import exercises.exercise03_dependencyInversion.annotations.CalculationMode;

@CalculationMode("-")
public class SubtractionStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
