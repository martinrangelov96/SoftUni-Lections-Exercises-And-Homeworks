package app.entities.races;

import app.entities.cars.Car;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    //•	“{route} - {length * laps}
    //•	 1. {brand} {model} {performancePoints}PP - ${moneyWon}
    //•	 2. {brand} {model} {performancePoints}PP - ${moneyWon}
    //•	 3. {brand} {model} {performancePoints}PP - ${moneyWon}
    //•	 4. {brand} {model} {performancePoints}PP - ${moneyWon}”

    @Override
    protected List<Car> getWinners() {
        return super.getParticipants()
                .stream()
                .sorted((car1, car2) -> {
                    return car2.getOverallPerformancePoints() -
                            car1.getOverallPerformancePoints();
                })
                .limit(4)
                .collect(Collectors.toList());
    }

    @Override
    protected int getPercentagePriceValue(int index) {
        switch (index) {
            case 0:
                return 40;
            case 1:
                return 30;
            case 2:
                return 20;
            case 3:
                return 10;
        }
        return 0;
    }

    private void decreaseDurability(Collection<Car> winners) {
        for (Car car : winners) {
            int decreasedDurability = car.getDurability() - (super.getLength() * super.getLength());
            car.setDurability(decreasedDurability);
        }
    }

    @Override
    public String toString() {
        StringBuilder circuitRace = new StringBuilder();
        Collection<Car> winners = this.getWinners();

        circuitRace
                .append(String.format("%s - %d", super.getRoute(), super.getLength() * this.laps))
                .append(System.lineSeparator());

        for (int i = 0; i < winners.size(); i++) {
            Car winner = ((List<Car>) winners).get(i);
            int moneyWon = (this.getPrizePool() * this.getPercentagePriceValue(i) / 100);
//            decreaseDurability(winners);
            circuitRace
                    .append(String.format("%d. %s %s %dPP - $%d",
                            i + 1, winner.getBrand(), winner.getModel(), winner.getOverallPerformancePoints(), moneyWon))
                    .append(System.lineSeparator());
        }

        return circuitRace.toString();
    }
}
