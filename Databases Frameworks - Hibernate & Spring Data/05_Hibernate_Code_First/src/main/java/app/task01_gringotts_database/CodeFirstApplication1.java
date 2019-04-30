package app.task01_gringotts_database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CodeFirstApplication1 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("wizard_deposits");

        EntityManager manager = factory.createEntityManager();

    }
}
