package blobs_previous_exam.factories;

import blobs_previous_exam.interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class BehaviourFactory {

    private static final String BEHAVIOUR_PATH = "blobs_previous_exam.models.behaviors.";

    private BehaviourFactory() {

    }

    public static Behavior create(String behaviourType) {
        Behavior behavior = null;
        try {
            Class<?> behaviourClass = Class.forName(BEHAVIOUR_PATH + behaviourType);
            Constructor<?> declaredConstructor = behaviourClass.getDeclaredConstructor();

            return (Behavior) declaredConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return behavior;
        }
    }
}
