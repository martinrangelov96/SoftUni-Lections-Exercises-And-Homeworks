package org.softuni.residentevil.web.repository;

import org.softuni.residentevil.web.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByAuthority(String authority);

    List<Role> findRolesById(String id);

}
