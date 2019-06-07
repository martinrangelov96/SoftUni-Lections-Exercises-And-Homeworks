package panda.service;

import panda.domain.models.service.ReceiptServiceModel;

import java.util.List;

public interface ReceiptService {

    void receiptCreate(ReceiptServiceModel receiptServiceModel);

    List<ReceiptServiceModel> findAllReceipts();
}
