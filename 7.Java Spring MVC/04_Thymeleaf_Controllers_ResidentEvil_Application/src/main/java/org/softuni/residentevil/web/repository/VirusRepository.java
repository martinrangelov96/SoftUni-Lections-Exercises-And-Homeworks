package org.softuni.residentevil.web.repository;

import org.softuni.residentevil.web.domain.entities.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirusRepository extends JpaRepository<Virus, Long> {
}
