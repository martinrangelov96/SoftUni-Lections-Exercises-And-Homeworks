package sbojgb.web.beans;

import sbojgb.domain.models.service.JobApplicationServiceModel;
import sbojgb.service.JobApplicationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class JobApplicationListBean {

    private List<JobApplicationServiceModel> serviceModels;

    private JobApplicationService jobApplicationService;

    public JobApplicationListBean() {
    }

    @Inject

    public JobApplicationListBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostConstruct
    public void init() {
        this.setServiceModels(this.jobApplicationService.getAllJobApplications());
        this.getServiceModels().forEach(j -> j.setSector(j.getSector().toLowerCase()));
    }

    public List<JobApplicationServiceModel> getServiceModels() {
        return serviceModels;
    }

    public void setServiceModels(List<JobApplicationServiceModel> serviceModels) {
        this.serviceModels = serviceModels;
    }

}
