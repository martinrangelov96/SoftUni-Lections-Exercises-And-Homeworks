package exodia.web.beans;

import exodia.domain.models.binding.UserRegisterBindingModel;
import exodia.domain.models.service.UserServiceModel;
import exodia.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UserRegisterBean {

    private UserRegisterBindingModel model;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModel() {
        this.model = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getModel() {
        return model;
    }

    public void setModel(UserRegisterBindingModel model) {
        this.model = model;
    }

    public void register() throws IOException {
        UserServiceModel userServiceModel = this.modelMapper.map(this.model, UserServiceModel.class);
        if (!this.model.getPassword().equals(this.model.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords don't match");
        }

        this.userService.registerUser(userServiceModel);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/login");
    }
}
