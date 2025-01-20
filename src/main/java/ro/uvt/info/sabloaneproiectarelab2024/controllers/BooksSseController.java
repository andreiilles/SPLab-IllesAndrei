package ro.uvt.info.sabloaneproiectarelab2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.CrudRepository;

@RestController
@RequestMapping("/books-sse")
public class BooksSseController {

    private final CrudRepository<Book, Integer> booksRepository;

    @Autowired
    public BooksSseController(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter();
        try {
            // Send each book as an event
            for (Book book : booksRepository.findAll()) {
                // This sends the data as an event
                emitter.send(SseEmitter.event().name("book").data(book));
            }
            emitter.complete();  // Marks the emitter as completed
        } catch (Exception e) {
            emitter.completeWithError(e);  // Handle errors if any
        }
        return emitter;
    }
}
