package exercises.exercise01_eventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String nameChanged;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.remove(nameChangeListener);
    }

    public void fireNameChangeEvent(EventNameChange event) {
        for (NameChangeListener nameChangeListener : nameChangeListeners) {
            nameChangeListener.handleChangedName(event);
        }
    }

    public void setNameChanged(String nameChanged) {
        this.nameChanged = nameChanged;
        EventNameChange nameChange = new EventNameChange(nameChanged);
        this.fireNameChangeEvent(nameChange);

    }
}
