package sbojgb.web.beans;

import sbojgb.domain.models.service.JobApplicationServiceModel;
import sbojgb.service.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Named
@RequestScoped
public class JobApplicationDeleteBean {

    private JobApplicationService jobApplicationService;

    public JobApplicationDeleteBean() {
    }

    @Inject
    public JobApplicationDeleteBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    public JobApplicationServiceModel getJobApplication(String id){
        JobApplicationServiceModel result = this.jobApplicationService.getJobById(id);

        return result;
    }

    public void delete() throws IOException {
        String id = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.jobApplicationService.delete(id);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/view/home.xhtml");
    }
}
