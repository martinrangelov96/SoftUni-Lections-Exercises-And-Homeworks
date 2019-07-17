package blobs_previous_exam.core.commands;

import blobs_previous_exam.annotations.Inject;
import blobs_previous_exam.factories.AttackFactory;
import blobs_previous_exam.factories.BehaviourFactory;
import blobs_previous_exam.factories.BlobFactory;
import blobs_previous_exam.interfaces.Attack;
import blobs_previous_exam.interfaces.Behavior;
import blobs_previous_exam.interfaces.Executable;
import blobs_previous_exam.interfaces.Repository;
import blobs_previous_exam.models.Blob;
import blobs_previous_exam.observers.Subject;
import blobs_previous_exam.utility.MutateBoolean;

public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Subject subject;

    @Inject
    private Boolean hasReportEvents;

    @Inject
    private MutateBoolean mutateBoolean;

    @Override
    public void execute() {
        String name = this.data[0];
        int health = Integer.parseInt(this.data[1]);
        int damage = Integer.parseInt(this.data[2]);
        String behaviourType = this.data[3];
        String attackType = this.data[4];

        Behavior behaviour = BehaviourFactory.create(behaviourType);
        Attack attack = AttackFactory.create(attackType);

        Blob blob = BlobFactory.create(name, health, damage, behaviour,
                attack, this.subject, this.mutateBoolean.getFlag());

        this.blobRepository.add(blob);
    }
}
