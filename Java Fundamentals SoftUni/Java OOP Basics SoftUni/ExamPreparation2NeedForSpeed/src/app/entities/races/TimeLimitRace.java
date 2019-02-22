package app.entities.races;

import app.entities.cars.Car;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }


    @Override
    public void addParticipant(Car car) {
        if (super.getParticipants().isEmpty()) {
            super.addParticipant(car);
        }
    }

    public int timePerformance(Car car) {
        return super.getLength()  * ((car.getHorsepower() / 100) * car.getAcceleration());
    }

    private String participantMedal;
    private int participantPrize;

    public void getMedalAndPrize(int timePerformance) {
        if (timePerformance <= this.goldTime) {
            this.participantMedal = "Gold";
            this.participantPrize = super.getPrizePool();
        } else if (timePerformance <= this.goldTime + 15) {
            this.participantMedal = "Silver";
            this.participantPrize = super.getPrizePool() - (super.getPrizePool() * 50)/100;
        } else if (timePerformance > this.goldTime + 15) {
            this.participantMedal = "Bronze";
            this.participantPrize = super.getPrizePool() - (super.getPrizePool() * 70)/100;
        }
    }

    @Override
    public String toString() {
        StringBuilder timeLimitRace = new StringBuilder();
        Car car = super.getParticipant();
        getMedalAndPrize(this.timePerformance(car));

        timeLimitRace
                .append(String.format("%s - %d", super.getRoute(), super.getLength()))
                .append(System.lineSeparator())
                .append(String.format("%s %s - %d s.",car.getBrand(), car.getModel(), this.timePerformance(car)))
                .append(System.lineSeparator())
                .append(String.format("%s Time, $%d.",this.participantMedal, this.participantPrize));

        return timeLimitRace.toString();
    }
}
