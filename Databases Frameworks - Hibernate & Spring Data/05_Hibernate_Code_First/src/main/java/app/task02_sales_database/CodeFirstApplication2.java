package app.task02_sales_database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CodeFirstApplication2 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("sales");

        EntityManager manager = factory.createEntityManager();

    }
}
