package p04_recharge;

public class MyRobot extends Robot implements Rechargeable {


    public MyRobot(String id, int capacity) {
        super(id, capacity);
    }

    @Override
    public void recharge() {
        super.setCurrentPower(this.getCapacity());
    }

}
