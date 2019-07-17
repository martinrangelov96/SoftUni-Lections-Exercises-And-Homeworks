package exodia.web.beans;

import exodia.domain.models.service.DocumentServiceModel;
import exodia.domain.models.view.DocumentPrintViewModel;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class DocumentPrintBean {

    private DocumentPrintViewModel model;

    private DocumentService documentService;
    private ModelMapper modelMapper;

    public DocumentPrintBean() {
    }

    @Inject
    public DocumentPrintBean(DocumentService documentService, ModelMapper modelMapper) {
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
            throw new IllegalArgumentException("Something went wrong while Printing documet");
        }

        this.model = this.modelMapper.map(documentServiceModel, DocumentPrintViewModel.class);
    }

    public DocumentPrintViewModel getModel() {
        return model;
    }

    public void setModel(DocumentPrintViewModel model) {
        this.model = model;
    }

    public DocumentServiceModel getDocumentServiceModel(String id) {
        DocumentServiceModel result = this.documentService.getDocumentById(id);

        return result;
    }

    public void deleteDocument() throws IOException {
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.documentService.deleteDocumentById(id);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/home");
    }
}
