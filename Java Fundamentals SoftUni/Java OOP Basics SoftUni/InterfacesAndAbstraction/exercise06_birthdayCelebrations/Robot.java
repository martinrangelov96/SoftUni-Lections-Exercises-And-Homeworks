package exercise06_birthdayCelebrations;

public class Robot implements Identifiable {

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public void getId(String id) {
        if (this.id.endsWith(id)) {
            System.out.println(this.id);
        }
    }
}
