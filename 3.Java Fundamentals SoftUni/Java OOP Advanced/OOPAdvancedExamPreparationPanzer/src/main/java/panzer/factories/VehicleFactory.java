package panzer.factories;

import panzer.contracts.Vehicle;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;

public final class VehicleFactory {

    private VehicleFactory() {

    }

    public static Vehicle createVehicle(String vehicleType, String vehicleModel, double vehicleWeight, BigDecimal vehiclePrice,
                                 int vehicleAttack, int vehicleDefense, int vehicleHitPoints) {

        switch (vehicleType) {
            case "Vanguard":
                return new Vanguard(vehicleModel, vehicleWeight, vehiclePrice,
                        vehicleAttack, vehicleDefense, vehicleHitPoints);
            case "Revenger":
                return new Revenger(vehicleModel, vehicleWeight, vehiclePrice,
                        vehicleAttack, vehicleDefense, vehicleHitPoints);
        }

        return null;
    }
}
