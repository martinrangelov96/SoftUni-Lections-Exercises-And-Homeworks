package sbojgb.repository;

import sbojgb.domain.entities.JobApplication;

public interface JobApplicationRepository extends GenericRepository<JobApplication, String> {

    void deleteById(String id);

}
