/**
 * Created by tomasz_taw
 * Date: 25.10.2023
 * Time: 20:59
 * Project Name: springbooks
 * Description:
 */
package pl.taw.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.taw.model.Author;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(int id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByName(String name) {
        return authors.stream()
                .filter(author -> author.fullName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostConstruct
    private void init() {
        authors.add(new Author(1, "Josh", "Long"));
        authors.add(new Author(2, "Mark", "Heckler"));
        authors.add(new Author(3, "Greg", "Turnquist"));
    }
}
