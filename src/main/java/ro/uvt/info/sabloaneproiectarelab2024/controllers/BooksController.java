package ro.uvt.info.sabloaneproiectarelab2024.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.services.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        Command<List<Book>> command = new GetAllBooksCommand(booksService);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Command<Optional<Book>> command = new GetBookByIdCommand(booksService, id);
        Optional<Book> result = command.execute();
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Command<Book> command = new CreateBookCommand(booksService, book);
        Book createdBook = command.execute();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Command<Optional<Book>> command = new UpdateBookCommand(booksService, id, updatedBook);
        Optional<Book> result = command.execute();
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Command<Boolean> command = new DeleteBookCommand(booksService, id);
        boolean deleted = command.execute();
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}