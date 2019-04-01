package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model,
                weight + ((100 * weight)/100),
                price,
                attack - ((25 * attack) /100),
                defense + ((50 * defense)/100),
                hitPoints + ((75 * hitPoints)/100));
    }


}
