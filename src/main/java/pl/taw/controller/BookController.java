/**
 * Created by tomasz_taw
 * Date: 25.10.2023
 * Time: 21:25
 * Project Name: springbooks
 * Description:
 */
package pl.taw.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import pl.taw.model.Book;
import pl.taw.repository.BookRepository;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public Book findOne(@Argument Integer id) {
        return bookRepository.findOne(id);
    }

    @QueryMapping
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

// TEN SPOSÓB TEŻ JEST POPRAWNY, ALE MOŻNA ZROBIĆ TO LEPIEJ - jak wyżej
//    @SchemaMapping(typeName = "Query", value = "allBooks")
//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }
}
