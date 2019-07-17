package sbojgb.repository;

import sbojgb.domain.entities.JobApplication;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobApplicationRepositoryImpl implements JobApplicationRepository {

    private final EntityManager entityManager;

    @Inject
    public JobApplicationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public JobApplication save(JobApplication entity) {
        this.entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<JobApplication> findAll() {
        this.entityManager.getTransaction().begin();
        List<JobApplication> jobApplications = this.entityManager
                .createQuery("SELECT j FROM JobApplication j", JobApplication.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return jobApplications;
    }

    @Override
    public JobApplication findById(String id) {
        this.entityManager.getTransaction().begin();
        try {
            JobApplication jobApplication = this.entityManager
                    .createQuery("SELECT j FROM JobApplication j WHERE j.id = :id", JobApplication.class)
                    .setParameter("id", id)
                    .getSingleResult();
            this.entityManager.getTransaction().commit();
            return jobApplication;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void deleteById(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager
                .createQuery("DELETE FROM JobApplication j WHERE j.id =:id")
                .setParameter("id", id)
                .executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}
