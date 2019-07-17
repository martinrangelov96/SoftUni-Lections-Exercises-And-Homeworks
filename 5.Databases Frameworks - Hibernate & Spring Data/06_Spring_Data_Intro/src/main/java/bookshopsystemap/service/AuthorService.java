package bookshopsystemap.service;

import bookshopsystemap.domain.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

}
