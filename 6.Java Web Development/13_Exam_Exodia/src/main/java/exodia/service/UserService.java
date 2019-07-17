package exodia.service;

import exodia.domain.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

}
