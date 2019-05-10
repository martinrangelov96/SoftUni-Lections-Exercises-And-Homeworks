package app.ccb.repositories;

import app.ccb.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("" +
            "SELECT e " +
            "FROM app.ccb.domain.entities.Employee e " +
            "WHERE concat(e.firstName, ' ', e.lastName) = :fullName")
    Optional<Employee> findByFullName(@Param(value = "fullName") String fullName);

    @Query("" +
            "SELECT e FROM app.ccb.domain.entities.Employee e " +
//            "JOIN e.clients " +
            "WHERE size(e.clients) > 0 " +
//            "GROUP BY e.id " +
            "ORDER BY size(e.clients) DESC, e.id ")
    List<Employee> extractTopEmployees();
}
