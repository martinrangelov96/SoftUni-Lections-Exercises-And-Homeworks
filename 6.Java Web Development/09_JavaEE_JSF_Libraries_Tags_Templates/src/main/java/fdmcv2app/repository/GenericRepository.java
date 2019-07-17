package fdmcv2app.repository;

import java.util.List;

public interface GenericRepository<E, ID> {

    E save(E entity);

    E findById(ID id);

    List<E> findAll();

}
