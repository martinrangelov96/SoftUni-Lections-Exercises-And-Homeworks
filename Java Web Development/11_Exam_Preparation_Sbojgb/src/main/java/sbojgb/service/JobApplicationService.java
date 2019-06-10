package sbojgb.service;

import sbojgb.domain.models.service.JobApplicationServiceModel;

import java.util.List;

public interface JobApplicationService {

    JobApplicationServiceModel createJobApplication(JobApplicationServiceModel jobApplicationServiceModel);

    List<JobApplicationServiceModel> getAllJobApplications();

    JobApplicationServiceModel getJobById(String id);

    void delete(String id);

}
