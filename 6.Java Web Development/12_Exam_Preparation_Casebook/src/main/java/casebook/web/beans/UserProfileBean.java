package casebook.web.beans;

import casebook.domain.models.service.UserServiceModel;
import casebook.domain.models.view.UserProfileViewModel;
import casebook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserProfileBean {

    private UserProfileViewModel model;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserProfileBean() {
    }

    @Inject
    public UserProfileBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModel() {
        String id = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");

UserServiceModel userServiceModel = this.userService.getUserById(id);

        if (userServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong with User Profile Page!");
        }

        this.model = this.modelMapper.map(userServiceModel, UserProfileViewModel.class);
    }

    public UserProfileViewModel getModel() {
        return model;
    }

    public void setModel(UserProfileViewModel model) {
        this.model = model;
    }

}
