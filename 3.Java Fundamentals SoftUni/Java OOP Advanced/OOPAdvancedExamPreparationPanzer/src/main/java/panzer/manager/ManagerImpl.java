package panzer.manager;

import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.factories.PartFactory;
import panzer.factories.VehicleFactory;

import java.math.BigDecimal;
import java.util.*;

public class ManagerImpl implements Manager {

    private Map<String, Vehicle> vehicles;
    private Map<String, Part> parts;
    private List<String> defeatedVehicles;
    private PanzerBattleOperator panzerBattleOperator;

    public ManagerImpl(PanzerBattleOperator panzerBattleOperator) {
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        this.panzerBattleOperator = panzerBattleOperator;
        this.defeatedVehicles = new LinkedList<>();
    }

    private Vehicle vehicle;

    @Override
    public String addVehicle(List<String> arguments) {
        String vehicleType = arguments.get(1);
        String vehicleModel = arguments.get(2);
        double vehicleWeight = Double.parseDouble(arguments.get(3));
        BigDecimal vehiclePrice = BigDecimal.valueOf(Long.parseLong(arguments.get(4)));
        int vehicleAttack = Integer.parseInt(arguments.get(5));
        int vehicleDefense = Integer.parseInt(arguments.get(6));
        int vehicleHitPoints = Integer.parseInt(arguments.get(7));

        vehicle = VehicleFactory.createVehicle(vehicleType, vehicleModel, vehicleWeight, vehiclePrice,
                vehicleAttack, vehicleDefense, vehicleHitPoints);

        this.vehicles.putIfAbsent(vehicleModel, vehicle);

        return String.format("Created %s Vehicle - %s", vehicleType, vehicleModel);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(1);
        String partType = arguments.get(2);
        String partModel = arguments.get(3);
        double partWeight = Double.parseDouble(arguments.get(4));
        BigDecimal partPrice = BigDecimal.valueOf(Long.parseLong(arguments.get(5)));
        int additionalPartParameter = Integer.parseInt(arguments.get(6));

        Part part = PartFactory.createPart(partType, partModel, partWeight, partPrice, additionalPartParameter);

        this.vehicle = vehicles.get(vehicleModel);

        this.parts.putIfAbsent(partModel, part);

        switch (partType) {
            case "Arsenal":
                this.vehicle.addArsenalPart(part);
                break;
            case "Shell":
                this.vehicle.addShellPart(part);
                break;
            case "Endurance":
                this.vehicle.addEndurancePart(part);
                break;
            default:
                break;
        }


        return String.format("Added %s - %s to Vehicle - %s",
                partType, partModel, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String vehicleModel = arguments.get(1);

        Vehicle vehicle = this.vehicles.get(vehicleModel);

        return vehicle.toString();
    }

    @Override
    public String battle(List<String> arguments) {
        String attackerVehicleModel = arguments.get(1);
        Vehicle attackerVehicle = this.vehicles.get(attackerVehicleModel);

        String targetVehicleModel = arguments.get(2);
        Vehicle targetVehicle = this.vehicles.get(targetVehicleModel);

        String winner = this.panzerBattleOperator.battle(attackerVehicle, targetVehicle);

        if (winner.equals(attackerVehicleModel)) {
            this.defeatedVehicles.add(targetVehicleModel);
            this.vehicles.remove(targetVehicleModel);
        } else {
            this.defeatedVehicles.add(attackerVehicleModel);
            this.vehicles.remove(attackerVehicleModel);
        }

        return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                attackerVehicleModel, targetVehicleModel, this.panzerBattleOperator.battle(attackerVehicle, targetVehicle));

    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        sb.append("Remaining Vehicles: ")
                .append(String.join(", ", vehicles.keySet()));


        sb.append(System.lineSeparator());

        sb.append("Defeated Vehicles: ");

        if (this.defeatedVehicles.size() == 0) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.defeatedVehicles));
        }

        final int[] currentUsedParts = {0};

        this.vehicles.entrySet().stream()
                .forEach(x -> {
                    List<Part> toJoin = new ArrayList<>((Collection<? extends Part>) x.getValue().getParts());
                    currentUsedParts[0] += toJoin.size();
                });

        sb.append(System.lineSeparator())
                .append(String.format("Currently Used Parts: %d", +currentUsedParts[0]));

        return sb.toString().trim();
    }
}
