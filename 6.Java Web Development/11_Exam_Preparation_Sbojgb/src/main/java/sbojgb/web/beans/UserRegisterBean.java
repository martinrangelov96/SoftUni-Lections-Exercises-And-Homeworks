package sbojgb.web.beans;

import org.modelmapper.ModelMapper;
import sbojgb.domain.models.binding.UserRegisterBindingModel;
import sbojgb.domain.models.service.UserServiceModel;
import sbojgb.service.UserService;

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
    private void initModel() {
        this.model = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getModel() {
        return model;
    }

    public void setModel(UserRegisterBindingModel model) {
        this.model = model;
    }

    public void register() throws IOException {
        if (!this.model.getPassword().equals(this.model.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords don't match");
        }

        this.userService.registerUser(this.modelMapper.map(this.model, UserServiceModel.class));
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/view/login.xhtml");
    }
}
