package org.softuni.residentevil.web.repository;

import org.softuni.residentevil.web.domain.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapitalRepository extends JpaRepository<Capital, Long> {

    @Query("SELECT c FROM Capital c ORDER BY c.name")
    List<Capital> findAllOrderByName();

}
