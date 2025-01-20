package ro.uvt.info.sabloaneproiectarelab2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.sabloaneproiectarelab2024.Author;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.AuthorsRepository;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.BooksRepository;
import ro.uvt.info.sabloaneproiectarelab2024.services.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksRepository booksRepository;
    private final AuthorsRepository authorRepository;
    @Autowired
    public BooksController(BooksRepository booksRepository, AuthorsRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        Command<List<Book>> command = new GetAllBooksCommand(booksRepository);
        return ResponseEntity.ok(command.execute());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Command<ResponseEntity<Book>> command = new GetBookByIdCommand(booksRepository, id);
        ResponseEntity<Book> result = command.execute();
        return result;
    }
    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Test POST Successful");
    }
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Command<Book> command = new CreateBookCommand(booksRepository, book);
        //List<Author> authors = authorRepository.findAllById(request.getAuthorIds());
        Book createdBook = command.execute();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
        Command<Optional<Book>> command = new UpdateBookCommand(booksRepository, id, updatedBook);
        Optional<Book> result = command.execute();
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        Command<Boolean> command = new DeleteBookCommand(booksRepository, id);
        boolean deleted = command.execute();
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}