package exodia.repository;

import exodia.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User save(User entity) {
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
    public List<User> findAll() {
        this.entityManager.getTransaction().begin();
        List<User> users = this.entityManager
                .createQuery("SELECT u FROM User u ", User.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return users;
    }

    @Override
    public User findById(String id) {
        this.entityManager.getTransaction().begin();
        try {
            User user = this.entityManager
                    .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                    .setParameter("id", id)
                    .getSingleResult();

            this.entityManager.getTransaction().commit();
            return user;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        this.entityManager.getTransaction().begin();
        try {
            User user = this.entityManager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();

            this.entityManager.getTransaction().commit();
            return user;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }
}
