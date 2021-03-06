package panda.service;

import org.modelmapper.ModelMapper;
import panda.domain.entities.Receipt;
import panda.domain.models.service.ReceiptServiceModel;
import panda.repository.ReceiptRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ModelMapper modelMapper) {
        this.receiptRepository = receiptRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void receiptCreate(ReceiptServiceModel receiptServiceModel) {
        Receipt receipt = this.modelMapper.map(receiptServiceModel, Receipt.class);
        this.receiptRepository.save(receipt);
    }

    @Override
    public List<ReceiptServiceModel> findAllReceipts() {
        return this.receiptRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, ReceiptServiceModel.class))
                .collect(Collectors.toList());
    }
}
