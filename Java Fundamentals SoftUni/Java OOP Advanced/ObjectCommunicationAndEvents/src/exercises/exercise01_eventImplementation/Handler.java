package exercises.exercise01_eventImplementation;

public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(EventNameChange event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getChangedName()));
    }

}
