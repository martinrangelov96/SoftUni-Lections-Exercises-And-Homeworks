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

public class AttackCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Override
    public void execute() {
        String sourceName = this.data[0];
        String targetName = this.data[1];

        Blob source = this.blobRepository.getByName(sourceName);
        Blob target = this.blobRepository.getByName(targetName);

        source.attack(target);
    }
}
