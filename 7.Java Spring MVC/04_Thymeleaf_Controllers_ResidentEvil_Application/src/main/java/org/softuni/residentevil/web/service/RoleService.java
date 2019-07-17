package org.softuni.residentevil.web.service;

import org.softuni.residentevil.web.domain.models.service.RoleServiceModel;

import java.util.List;

public interface RoleService {

    List<RoleServiceModel> findRolesById(String id);

    List<RoleServiceModel> findAllRoles();
}
