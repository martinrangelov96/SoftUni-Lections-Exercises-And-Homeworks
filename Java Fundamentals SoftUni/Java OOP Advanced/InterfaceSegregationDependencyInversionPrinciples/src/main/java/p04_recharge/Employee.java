package p04_recharge;

public class Employee extends BaseWorker implements Sleeper {

    public Employee(String id) {
        super(id);
    }

    public void sleep() {
        // sleep...
    }
}
