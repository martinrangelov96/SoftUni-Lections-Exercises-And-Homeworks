package blobs_previous_exam.factories;

import blobs_previous_exam.interfaces.Attack;
import blobs_previous_exam.interfaces.Behavior;
import blobs_previous_exam.models.Blob;
import blobs_previous_exam.observers.Subject;

public final class BlobFactory {

    private BlobFactory() {

    }

    public static Blob create(String name, int health,
                              int damage, Behavior behaviour, Attack attack, Subject subject, boolean flag) {

        return new Blob(name, health, damage, behaviour, attack, subject, flag);
    }
}
