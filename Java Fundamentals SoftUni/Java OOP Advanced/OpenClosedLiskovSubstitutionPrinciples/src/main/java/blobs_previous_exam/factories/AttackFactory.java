package blobs_previous_exam.factories;

import blobs_previous_exam.interfaces.Attack;
import blobs_previous_exam.interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AttackFactory {

    private static final String ATTACK_PATH = "blobs_previous_exam.models.attacks.";

    private AttackFactory() {

    }

    public static Attack create(String attackType) {
        Attack attack = null;
        try {
            Class<?> attackClass = Class.forName(ATTACK_PATH + attackType);
            Constructor<?> declaredConstructor = attackClass.getDeclaredConstructor();

            return (Attack) declaredConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return attack;
        }
    }
}
