package panda.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationConfigurationBean {

    @Produces
    public EntityManager entityManager() {
        return Persistence.
                createEntityManagerFactory("pandaPU")
                .createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
