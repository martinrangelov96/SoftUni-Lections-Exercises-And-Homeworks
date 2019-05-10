package bookshopsystemapp.advancedqueringexercise.service;

import bookshopsystemapp.advancedqueringexercise.domain.entities.Author;
import bookshopsystemapp.advancedqueringexercise.repository.AuthorRepository;
import bookshopsystemapp.advancedqueringexercise.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final static String AUTHORS_FILE_PATH = "D:\\Programming stuff\\IdeaUltimateProjects\\07_Spring_Data_Advanced_Quering_Exercise\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHORS_FILE_PATH);
        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");

            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public List<String> authorsWithFirstNameEndsWith(String endsWith) {
        List<Author> authors = this.authorRepository.findAllByFirstNameEndsWith(endsWith);
        return authors.stream()
                .map(author -> String.format("%s %s", author.getFirstName(), author.getLastName()))
                    .collect(Collectors.toList());
    }
}
