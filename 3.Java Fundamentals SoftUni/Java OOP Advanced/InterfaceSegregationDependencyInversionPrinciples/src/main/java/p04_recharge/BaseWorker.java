package p04_recharge;

public abstract class BaseWorker implements Worker {

    private String id;
    private int workingHours;

    public BaseWorker(String id) {
        this.id = id;
    }

    @Override
    public void work(int hours) {
        this.workingHours += hours;
    }
}
