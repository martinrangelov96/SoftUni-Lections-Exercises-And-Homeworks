package sbojgb.service;

import sbojgb.domain.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel getUserByUsername(String username);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

}
