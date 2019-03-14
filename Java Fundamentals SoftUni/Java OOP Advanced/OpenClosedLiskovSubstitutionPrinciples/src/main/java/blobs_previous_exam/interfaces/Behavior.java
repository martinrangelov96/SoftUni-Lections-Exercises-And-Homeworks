package blobs_previous_exam.interfaces;

import blobs_previous_exam.models.Blob;

public interface Behavior {

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);

    boolean isTriggered();
}
