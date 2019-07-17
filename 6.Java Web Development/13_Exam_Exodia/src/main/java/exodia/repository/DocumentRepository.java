package exodia.repository;

import exodia.domain.entities.Document;

public interface DocumentRepository extends GenericRepository<Document, String> {

    void deleteById(String id);

}
