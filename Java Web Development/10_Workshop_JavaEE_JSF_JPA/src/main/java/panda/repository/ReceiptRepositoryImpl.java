package panda.repository;

import panda.domain.entities.Receipt;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private final EntityManager entityManager;

    @Inject
    public ReceiptRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Receipt save(Receipt entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Receipt> findAll() {
        this.entityManager.getTransaction().begin();
        List<Receipt> receipts = this.entityManager
                .createQuery("SELECT r FROM receipts r", Receipt.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return receipts;
    }

    @Override
    public Receipt findById(String id) {
        this.entityManager.getTransaction().begin();
        Receipt receipt = this.entityManager
                .createQuery("SELECT r FROM receipts r WHERE r.id = :id", Receipt.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return receipt;
    }

    @Override
    public Long size() {
        this.entityManager.getTransaction().begin();
        Long size = this.entityManager
                .createQuery("SELECT count(r) FROM receipts r", Long.class)
                .getSingleResult();
        this.entityManager.getTransaction().commit();
        return size;
    }
}
