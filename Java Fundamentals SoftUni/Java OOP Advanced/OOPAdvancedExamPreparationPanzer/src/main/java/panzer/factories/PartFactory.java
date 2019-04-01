package panzer.factories;

import panzer.contracts.Part;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;

import java.math.BigDecimal;

public final class PartFactory {

    private PartFactory() {
    }

    public static Part createPart(String partType, String partModel, double partWeight, BigDecimal partPrice, int additionalPartParameter) {

        switch (partType) {
            case "Arsenal":
                return new ArsenalPart(partModel, partWeight, partPrice, additionalPartParameter);
            case "Shell":
                return new ShellPart(partModel, partWeight, partPrice, additionalPartParameter);
            case "Endurance":
                return new EndurancePart(partModel, partWeight, partPrice, additionalPartParameter);
        }

        return null;
    }
}
