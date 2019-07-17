package sbojgb.web.beans;

import org.modelmapper.ModelMapper;
import sbojgb.domain.models.binding.UserLoginBindingModel;
import sbojgb.domain.models.service.UserServiceModel;
import sbojgb.service.UserService;

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
    private void initModel() {
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/view/login.xhtml");
            throw new IllegalArgumentException("Wrong username or password!");
        }

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("username", userServiceModel.getUsername());
        session.setAttribute("id", userServiceModel.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/view/home.xhtml");
    }
}
