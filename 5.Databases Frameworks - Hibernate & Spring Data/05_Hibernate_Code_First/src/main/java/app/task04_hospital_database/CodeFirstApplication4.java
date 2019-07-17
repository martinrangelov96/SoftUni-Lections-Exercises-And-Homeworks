package app.task04_hospital_database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CodeFirstApplication4 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("hospital");

        EntityManager manager = factory.createEntityManager();

    }
}
