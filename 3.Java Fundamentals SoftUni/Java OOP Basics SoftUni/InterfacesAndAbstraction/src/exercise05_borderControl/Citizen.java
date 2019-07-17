package exercise05_borderControl;

public class Citizen implements Identifiable {

    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public void getId(String id) {
        if (this.id.endsWith(id)) {
            System.out.println(this.id);
        }
    }
}
