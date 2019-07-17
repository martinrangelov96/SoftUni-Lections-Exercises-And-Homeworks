package lecture03_carShowExtended;

public class Main {
    public static void main(String[] args) {

        Sellable seat = new Seat("Spain", "Leon",
                110, "Gray", 11111.1);
        Rentable audi = new Audi("Spain", "Leon", "Gray", 110,
                3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);

    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }

}
