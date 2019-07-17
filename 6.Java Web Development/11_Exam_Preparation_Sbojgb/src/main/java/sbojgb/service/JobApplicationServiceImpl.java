package sbojgb.service;

import org.modelmapper.ModelMapper;
import sbojgb.domain.entities.JobApplication;
import sbojgb.domain.models.service.JobApplicationServiceModel;
import sbojgb.repository.JobApplicationRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final ModelMapper modelMapper;

    @Inject
    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository, ModelMapper modelMapper) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JobApplicationServiceModel createJobApplication(JobApplicationServiceModel jobApplicationServiceModel) {
        JobApplication jobApplication = this.modelMapper.map(jobApplicationServiceModel, JobApplication.class);
        return this.modelMapper.map(this.jobApplicationRepository.save(jobApplication), JobApplicationServiceModel.class);
    }

    @Override
    public List<JobApplicationServiceModel> getAllJobApplications() {
        return this.jobApplicationRepository.findAll()
                .stream()
                .map(j -> this.modelMapper.map(j, JobApplicationServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobApplicationServiceModel getJobById(String id) {
        return this.modelMapper.map(this.jobApplicationRepository.findById(id), JobApplicationServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.jobApplicationRepository.deleteById(id);
    }
}
