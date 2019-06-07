package panda.web.beans;

import org.modelmapper.ModelMapper;
import panda.domain.models.binding.ReceiptCreateBindingModel;
import panda.domain.models.service.ReceiptServiceModel;
import panda.service.ReceiptService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class ReceiptCreateBean {

    private List<String> receipts;
    private ReceiptCreateBindingModel model;

    private ReceiptService receiptService;
    private ModelMapper modelMapper;

    public ReceiptCreateBean() {
    }

    @Inject
    public ReceiptCreateBean(ReceiptService receiptService, ModelMapper modelMapper) {
        this.receiptService = receiptService;
        this.modelMapper = modelMapper;
        this.initReceipts();
        this.initModel();
    }

    private void initReceipts() {
        this.receipts = this.receiptService.findAllReceipts()
                .stream()
                .map(r -> r.getRecipient().getUsername())
                .collect(Collectors.toList());
    }


    private void initModel() {
        this.model = new ReceiptCreateBindingModel();
    }

    public List<String> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<String> receipts) {
        this.receipts = receipts;
    }

    public ReceiptCreateBindingModel getModel() {
        return model;
    }

    public void setModel(ReceiptCreateBindingModel model) {
        this.model = model;
    }

    public void createReceipt() throws IOException {
        //TODO: map the fields and put action in home.xhtml
        ReceiptServiceModel receiptServiceModel = this.modelMapper.map(this.model, ReceiptServiceModel.class);

        this.receiptService.receiptCreate(receiptServiceModel);
//        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/view/receipts.xhtml");
    }
}
