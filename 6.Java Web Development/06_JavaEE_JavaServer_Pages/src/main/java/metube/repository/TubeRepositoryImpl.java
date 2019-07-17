package metube.repository;

import metube.domain.entities.Tube;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class TubeRepositoryImpl implements TubeRepository {

    private EntityManager entityManager;

    public TubeRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("metube")
                .createEntityManager();
    }

    @Override
    public Optional<Tube> findByName(String name) {
        try {
            Optional<Tube> tube = Optional.of(entityManager
                    .createQuery("" +
                            "SELECT t " +
                            "FROM tubes t " +
                            "WHERE t.name = :name", Tube.class)
                    .setParameter("name", name)
                    .getSingleResult());

            return tube;
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    @Override
    public Tube save(Tube tube) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(tube);
        this.entityManager.getTransaction().commit();

        return tube;
    }

    @Override
    public List<Tube> findAll() {
        return this.entityManager
                .createQuery("" +
                        "SELECT t " +
                        "FROM tubes t " +
                        "", Tube.class)
                .getResultList();
    }

    @Override
    public Optional<Tube> findById(String s) {
        try {
            Optional<Tube> tube = Optional.of(entityManager
                    .createQuery("" +
                            "SELECT t " +
                            "FROM tubes t " +
                            "WHERE t.id = :id", Tube.class)
                    .setParameter("id", s)
                    .getSingleResult());

            return tube;
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }
}
