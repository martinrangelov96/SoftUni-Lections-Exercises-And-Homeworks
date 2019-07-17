package exodia.web.beans;

import exodia.domain.models.binding.DocumentScheduleBindingModel;
import exodia.domain.models.service.DocumentServiceModel;
import exodia.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean {

    private List<DocumentScheduleBindingModel> models;

    private DocumentService documentService;
    private ModelMapper modelMapper;

    public HomeBean() {
    }

    @Inject
    public HomeBean(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initModels() {
        this.models = this.documentService.getAllDocuments()
                .stream()
                .map(d -> this.modelMapper.map(d, DocumentScheduleBindingModel.class))
                .collect(Collectors.toList());
    }

    public List<DocumentScheduleBindingModel> getModels() {
        return models;
    }

    public void setModels(List<DocumentScheduleBindingModel> models) {
        this.models = models;
    }

}
