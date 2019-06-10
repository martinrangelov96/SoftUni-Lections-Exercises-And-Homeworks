package sbojgb.web.beans;

import sbojgb.domain.models.service.JobApplicationServiceModel;
import sbojgb.service.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobApplicationDetailsBean {

    private JobApplicationService jobApplicationService;

    public JobApplicationDetailsBean() {
    }

    @Inject
    public JobApplicationDetailsBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    public JobApplicationServiceModel getJobApplication(String id){
        return this.jobApplicationService.getJobById(id);
    }
}
