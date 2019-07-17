package mostwanted.repository;

import mostwanted.domain.entities.Racer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacerRepository extends JpaRepository<Racer, Integer> {
    Optional<Racer> findByName(String name);

    @Query("SELECT r " +
            "FROM mostwanted.domain.entities.Racer AS r " +
            "JOIN r.cars AS c " +
            "GROUP BY r " +
            "ORDER BY size(r.cars) DESC, r.name ASC ")
    List<Racer> findRacingCars();
}
