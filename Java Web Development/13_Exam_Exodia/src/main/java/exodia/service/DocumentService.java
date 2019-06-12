package exodia.service;

import exodia.domain.models.service.DocumentServiceModel;

import java.util.List;

public interface DocumentService {

    DocumentServiceModel saveDocument(DocumentServiceModel documentServiceModel);

    List<DocumentServiceModel> getAllDocuments();

    DocumentServiceModel getDocumentById(String id);

    void deleteDocumentById(String id);

}
