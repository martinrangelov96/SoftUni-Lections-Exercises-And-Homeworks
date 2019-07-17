package casebook.web.beans;

import casebook.domain.models.service.UserServiceModel;
import casebook.domain.models.view.UserFriendsViewModel;
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
public class UserFriendsBean {

    private List<UserFriendsViewModel> models;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserFriendsBean() {
    }

    @Inject
    public UserFriendsBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModels() {
        String id = (String) ((HttpSession) FacesContext
                .getCurrentInstance().getExternalContext()
                .getSession(false))
                .getAttribute("id");

        this.models = this.userService.getUserById(id).getFriends()
                .stream()
                .map(f -> this.modelMapper.map(f, UserFriendsViewModel.class))
                .collect(Collectors.toList());
    }

    public List<UserFriendsViewModel> getModels() {
        return models;
    }

    public void setModels(List<UserFriendsViewModel> models) {
        this.models = models;
    }

    public void removeFriend(String id) throws IOException {
        UserServiceModel loggedInUser = this.userService.getUserById((String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("id"));
        UserServiceModel userServiceModel = this.userService.getUserById(id);

        loggedInUser.getFriends().remove(userServiceModel);
        userServiceModel.getFriends().remove(loggedInUser);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/friends");
    }
}
