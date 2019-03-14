package blobs_previous_exam.models.attacks;

import blobs_previous_exam.interfaces.Attack;
import blobs_previous_exam.models.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob source, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= source.getDamage();
        target.setHealth(currentHealth);
    }

}
