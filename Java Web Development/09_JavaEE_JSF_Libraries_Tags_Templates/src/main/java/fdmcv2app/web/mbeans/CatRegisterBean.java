package fdmcv2app.web.mbeans;

import fdmcv2app.domain.models.binding.CatRegisterBindingModel;
import fdmcv2app.domain.models.service.CatServiceModel;
import fdmcv2app.service.CatService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class CatRegisterBean {

    private CatRegisterBindingModel catRegisterBindingModel;

    private CatService catService;
    private ModelMapper modelMapper;

    public CatRegisterBean() {
        this.catRegisterBindingModel = new CatRegisterBindingModel();
    }

    @Inject
    public CatRegisterBean(CatService catService, ModelMapper modelMapper) {
        this();
        this.catService = catService;
        this.modelMapper = modelMapper;
    }

    public void register() throws IOException {
        this.catService.saveCat(this.modelMapper.map(this.catRegisterBindingModel, CatServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }

    public CatRegisterBindingModel getCatRegisterBindingModel() {
        return catRegisterBindingModel;
    }

    public void setCatRegisterBindingModel(CatRegisterBindingModel catRegisterBindingModel) {
        this.catRegisterBindingModel = catRegisterBindingModel;
    }
}
