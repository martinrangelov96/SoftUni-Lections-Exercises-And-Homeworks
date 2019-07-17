package blobs_previous_exam.core.commands;

import blobs_previous_exam.annotations.Inject;
import blobs_previous_exam.interfaces.Executable;
import blobs_previous_exam.interfaces.Repository;
import blobs_previous_exam.interfaces.Writer;
import blobs_previous_exam.models.Blob;

public class StatusCommand implements Executable {

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Writer writer;

    @Override
    public void execute() {
        this.blobRepository
                .findAll()
                .forEach(blob -> this.writer.writeLine(blob.toString()));
    }
}
