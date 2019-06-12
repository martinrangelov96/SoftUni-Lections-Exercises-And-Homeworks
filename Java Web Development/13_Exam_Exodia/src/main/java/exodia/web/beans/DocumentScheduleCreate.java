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
//        String id = FacesContext
//                .getCurrentInstance()
//                .getExternalContext()
//                .getRequestParameterMap()
//                .get("id");
//
//        DocumentServiceModel documentServiceModel = this.documentService.getDocumentById(id);
//
//        if (documentServiceModel == null) {
//            throw new IllegalArgumentException("Something went wrong while visiting re-routing to Details page.");
//        }

        this.model = new DocumentScheduleBindingModel();
    }

    public DocumentScheduleBindingModel getModel() {
        return model;
    }

    public void setModel(DocumentScheduleBindingModel model) {
        this.model = model;
    }

    public void saveDocument() throws IOException {
        DocumentServiceModel documentServiceModel = this.modelMapper.map(this.model, DocumentServiceModel.class);

        if (documentServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong while visiting re-routing to Details page.");
        }

        this.documentService.saveDocument(documentServiceModel);

        String id = documentServiceModel.getId();

        FacesContext.getCurrentInstance().getExternalContext().redirect(String.format("/details?id=%s", id));
    }
}
