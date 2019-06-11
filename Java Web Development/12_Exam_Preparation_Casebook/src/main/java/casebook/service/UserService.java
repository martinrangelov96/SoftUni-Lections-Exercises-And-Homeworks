package casebook.service;

import casebook.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel getUserByUsername(String username);

    UserServiceModel loginUser(UserServiceModel userServiceModel);

    UserServiceModel getUserById(String id);

    List<UserServiceModel> getAllUsers();

    boolean addFriend(UserServiceModel userServiceModel);

    boolean removeUser(UserServiceModel userServiceModel);

}
