package exodia.web.beans;

import exodia.domain.models.service.DocumentServiceModel;
import exodia.domain.models.view.DocumentDetailsViewModel;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DocumentDetailsBean {

    private DocumentDetailsViewModel model;

    private DocumentService documentService;
    private ModelMapper modelMapper;

    public DocumentDetailsBean() {
    }

    @Inject
    public DocumentDetailsBean(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModel() {
        String id = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("id");

        DocumentServiceModel documentServiceModel = this.documentService.getDocumentById(id);

        if (documentServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong while visiting Details page.");
        }

        this.model = this.modelMapper.map(documentServiceModel, DocumentDetailsViewModel.class);
    }

    public DocumentDetailsViewModel getModel() {
        return model;
    }

    public void setModel(DocumentDetailsViewModel model) {
        this.model = model;
    }
}
