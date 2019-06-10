package sbojgb.web.beans;

import org.modelmapper.ModelMapper;
import sbojgb.domain.models.binding.JobApplicationCreateBindingModel;
import sbojgb.domain.models.service.JobApplicationServiceModel;
import sbojgb.service.JobApplicationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class JobApplicationCreateBean {

    private JobApplicationCreateBindingModel model;

    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    public JobApplicationCreateBean() {
    }

    @Inject
    public JobApplicationCreateBean(JobApplicationService jobApplicationService, ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void initModel() {
        this.model = new JobApplicationCreateBindingModel();
    }


    public JobApplicationCreateBindingModel getModel() {
        return model;
    }

    public void setModel(JobApplicationCreateBindingModel model) {
        this.model = model;
    }

    public void createJobApplication() throws IOException {
        JobApplicationServiceModel jobApplicationServiceModel = this.modelMapper.map(this.model, JobApplicationServiceModel.class);
        this.jobApplicationService.createJobApplication(jobApplicationServiceModel);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/view/home.xhtml");
    }
}
