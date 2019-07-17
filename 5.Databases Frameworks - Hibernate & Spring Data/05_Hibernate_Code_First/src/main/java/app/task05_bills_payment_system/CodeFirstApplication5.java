package app.task05_bills_payment_system;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CodeFirstApplication5 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("bills_payment_system");

        EntityManager manager = factory.createEntityManager();

    }
}
