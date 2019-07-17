package exodia.web.beans;

import exodia.domain.models.binding.DocumentScheduleBindingModel;
import exodia.domain.models.service.DocumentServiceModel;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Named
@RequestScoped
public class DocumentScheduleCreate {

    private DocumentScheduleBindingModel model;

    private DocumentService documentService;
    private ModelMapper modelMapper;

    public DocumentScheduleCreate() {
    }

    @Inject
    public DocumentScheduleCreate(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModel() {
        this.model = new DocumentScheduleBindingModel();
    }

    public DocumentScheduleBindingModel getModel() {
        return model;
    }

    public void setModel(DocumentScheduleBindingModel model) {
        this.model = model;
    }

    public void saveDocument() throws IOException {
        DocumentServiceModel documentServiceModel = this.documentService.saveDocument(this.modelMapper.map(this.model, DocumentServiceModel.class));

        String id = documentServiceModel.getId();

        FacesContext.getCurrentInstance().getExternalContext().redirect(String.format("/details?id=%s", id));
    }
}
