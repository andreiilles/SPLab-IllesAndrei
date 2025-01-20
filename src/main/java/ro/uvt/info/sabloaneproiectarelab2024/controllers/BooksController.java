package ro.uvt.info.sabloaneproiectarelab2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.sabloaneproiectarelab2024.Author;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.AuthorsRepository;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.BooksRepository;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.CrudRepository;
import ro.uvt.info.sabloaneproiectarelab2024.services.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CrudRepository<Book, Integer> booksRepository;
    private final AllBooksSubject allBooksSubject;;
    @Autowired
    public BooksController(CrudRepository<Book,Integer> booksRepository, AllBooksSubject allBooksSubject) {
        this.booksRepository = booksRepository;
        this.allBooksSubject = allBooksSubject;
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> book = booksRepository.findAll();
        return ResponseEntity.ok(book);
    }
    @GetMapping("/sse")
    public SseEmitter getAllBooksSse() {
        SseEmitter emitter = new SseEmitter();

        // Run the logic in a separate thread to avoid blocking the main thread
        new Thread(() -> {
            try {
                while (true) {  // Periodically send updates
                    List<Book> books = booksRepository.findAll();
                    if (!books.isEmpty()) {
                        for (Book book : books) {
                            emitter.send(book);  // Send each book as an event
                        }
                    }
                    // Wait for a period of time before sending the next set of books
                    Thread.sleep(60000);  // Sleep for 5 seconds, adjust as needed
                }
            } catch (IOException | InterruptedException ex) {
                // Handle the exception
                emitter.completeWithError(ex);
            }
        }).start();

        return emitter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Optional<Book> book = booksRepository.findById(id);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Test POST Successful");
    }
    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = booksRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
        Optional<Book> existingBook = booksRepository.findById(id);
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            bookToUpdate.setTitle(updatedBook.getTitle());
            Book savedBook = booksRepository.save(bookToUpdate);
            return ResponseEntity.ok(savedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        Optional<Book> existingBook = booksRepository.findById(id);
        if (existingBook.isPresent()) {
            booksRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}