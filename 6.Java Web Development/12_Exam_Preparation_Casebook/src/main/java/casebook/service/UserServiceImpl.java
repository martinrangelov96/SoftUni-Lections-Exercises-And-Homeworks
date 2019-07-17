package casebook.service;

import casebook.domain.entities.User;
import casebook.domain.models.service.UserServiceModel;
import casebook.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        userServiceModel.setPassword(DigestUtils.sha256Hex(userServiceModel.getPassword()));
        User user = this.modelMapper.map(userServiceModel, User.class);
        this.userRepository.save(user);

        return userServiceModel;
    }

    @Override
    public UserServiceModel getUserByUsername(String username) {
        User user = this.userRepository.findUserByUsername(username);
        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {
        User user = this.userRepository.findUserByUsername(userServiceModel.getUsername());

        if (user == null || !user.getPassword().equals(DigestUtils.sha256Hex(userServiceModel.getPassword()))) {
            return null;
        }

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel getUserById(String id) {
        User user = this.userRepository.findById(id);
        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> getAllUsers() {
        List<UserServiceModel> userServiceModels = this.userRepository.findAll()
                .stream()
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .collect(Collectors.toList());
        return userServiceModels;
    }

    @Override
    public boolean addFriend(UserServiceModel userServiceModel) {
        User user = this.userRepository.update(this.modelMapper.map(userServiceModel, User.class));

        if (user != null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean removeUser(UserServiceModel userServiceModel) {

        if (this.userRepository.deleteById(userServiceModel.getId())) {
            return true;
        }

        return false;
    }

}
