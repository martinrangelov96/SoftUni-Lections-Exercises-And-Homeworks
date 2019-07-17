package blobs_previous_exam.core.commands;

import blobs_previous_exam.annotations.Inject;
import blobs_previous_exam.interfaces.Executable;
import blobs_previous_exam.interfaces.Repository;
import blobs_previous_exam.models.Blob;
import blobs_previous_exam.utility.MutateBoolean;

public class ReportEventsCommand implements Executable {

    @Inject
    private MutateBoolean mutateBoolean;

    @Override
    public void execute() {
        this.mutateBoolean.setFlag(true);
    }
}
