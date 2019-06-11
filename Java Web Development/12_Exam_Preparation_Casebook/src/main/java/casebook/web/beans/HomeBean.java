package casebook.web.beans;

import casebook.domain.entities.User;
import casebook.domain.models.service.UserServiceModel;
import casebook.domain.models.view.UserHomeViewModel;
import casebook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean {

    private List<UserHomeViewModel> models;

    private UserService userService;
    private ModelMapper modelMapper;

    public HomeBean() {
    }

    @Inject
    public HomeBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModels() {
        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

        String id = (String) ((HttpSession) FacesContext
                .getCurrentInstance().getExternalContext()
                .getSession(false))
                .getAttribute("id");

        UserServiceModel loggedInUser = this.userService.getUserById(id);

        this.models = this.userService.getAllUsers()
                .stream()
                .filter(u -> !u.getUsername().equals(username) &&
                        !loggedInUser.getFriends()
                                .stream()
                                .map(f -> f.getUsername())
                                .collect(Collectors.toList()).contains(u.getUsername()))
                .map(userServiceModel -> this.modelMapper.map(userServiceModel, UserHomeViewModel.class))
                .collect(Collectors.toList());
    }

    public List<UserHomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<UserHomeViewModel> models) {
        this.models = models;
    }

    public void addFriend(String id) throws IOException {
        UserServiceModel loggedInUser = this.userService.getUserById((String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("id"));
        UserServiceModel userServiceModel = this.userService.getUserById(id);

        loggedInUser.getFriends().add(userServiceModel);

        userServiceModel.getFriends().add(loggedInUser);

        if (!this.userService.addFriend(loggedInUser)) {
            throw new IllegalArgumentException("Exception while adding friend");
        }

        if (!this.userService.addFriend(userServiceModel)) {
            throw new IllegalArgumentException("Exception while adding friend");
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("/home");
    }

}
