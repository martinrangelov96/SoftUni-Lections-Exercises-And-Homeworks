package exodia.web.beans;

import exodia.domain.models.binding.UserLoginBindingModel;
import exodia.domain.models.binding.UserRegisterBindingModel;
import exodia.domain.models.service.UserServiceModel;
import exodia.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class UserLoginBean {

    private UserLoginBindingModel model;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModel() {
        this.model = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getModel() {
        return model;
    }

    public void setModel(UserLoginBindingModel model) {
        this.model = model;
    }

    public void login() throws IOException {
        UserServiceModel userServiceModel = this.userService.loginUser(this.modelMapper.map(this.model, UserServiceModel.class));

        if (userServiceModel == null) {
            throw new IllegalArgumentException("Wrong username or password");
        }


        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        session.setAttribute("username", userServiceModel.getUsername());
        session.setAttribute("id", userServiceModel.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect("/home");

    }
}
