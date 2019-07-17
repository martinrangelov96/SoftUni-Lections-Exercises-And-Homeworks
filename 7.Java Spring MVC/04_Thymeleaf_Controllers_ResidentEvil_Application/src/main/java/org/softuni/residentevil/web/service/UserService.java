package org.softuni.residentevil.web.service;

import org.softuni.residentevil.web.domain.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    boolean registerUser(UserServiceModel userServiceModel);

    List<UserServiceModel> findAllUsers();
}
