package metubev2.repository;

import metubev2.domain.entities.Tube;

public interface TubeRepository extends GenericRepository<Tube, String> {

    Tube update(Tube tube);

}
