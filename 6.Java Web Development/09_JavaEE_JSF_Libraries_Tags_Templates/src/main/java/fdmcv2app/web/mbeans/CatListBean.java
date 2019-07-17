package fdmcv2app.web.mbeans;

import fdmcv2app.domain.models.view.CatListViewModel;
import fdmcv2app.service.CatService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class CatListBean {

    private List<CatListViewModel> cats;

    private CatService catService;
    private ModelMapper modelMapper;

    public CatListBean() {
    }

    @Inject
    public CatListBean(CatService catService, ModelMapper modelMapper) {
        this.catService = catService;
        this.modelMapper = modelMapper;
        this.cats = this.catService.findAllCats()
                .stream()
                .map(catServiceModel -> this.modelMapper.map(catServiceModel, CatListViewModel.class))
                .collect(Collectors.toList());
    }

    public List<CatListViewModel> getCats() {
        return cats;
    }

    public void setCats(List<CatListViewModel> cats) {
        this.cats = cats;
    }
}
