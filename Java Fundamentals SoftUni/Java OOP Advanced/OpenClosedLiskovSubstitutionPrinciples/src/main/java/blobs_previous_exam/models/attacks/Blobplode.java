package blobs_previous_exam.models.attacks;

import blobs_previous_exam.interfaces.Attack;
import blobs_previous_exam.models.Blob;

public class Blobplode implements Attack {

    @Override
    public void execute(Blob source, Blob target) {
        int sourceHealthAfterAttack = source.getHealth() - (source.getHealth() / 2);
        if (sourceHealthAfterAttack >= 1) {
            source.setHealth(sourceHealthAfterAttack);
        }

        target.setHealth(target.getHealth() - (source.getDamage() * 2));
    }
}
