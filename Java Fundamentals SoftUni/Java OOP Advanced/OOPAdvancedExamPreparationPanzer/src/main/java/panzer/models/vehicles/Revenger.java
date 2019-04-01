package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends BaseVehicle {

    //•	Price – increases its given price by 50%.
    //•	Attack – increases its given attack by 150%.
    //•	Defense – decreases its given defense by 50%.
    //•	HitPoints – decreases its given hitPoints by 50%.

    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model,
                weight,
                price.multiply(BigDecimal.valueOf(1.5)),
                attack + ((150 * attack) / 100),
                defense - ((50 * defense) / 100),
                hitPoints - ((50 * hitPoints) / 100));
    }
}
