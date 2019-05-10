package bookshopsystemapp.advancedqueringexercise.service;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    List<String> authorsWithFirstNameEndsWith(String endsWith);
}
