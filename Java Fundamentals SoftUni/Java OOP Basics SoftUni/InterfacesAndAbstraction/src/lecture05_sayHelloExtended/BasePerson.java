package lecture05_sayHelloExtended;

public abstract class BasePerson implements Person{
    private String name;

    BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
