package ro.uvt.info.sabloaneproiectarelab2024.services;

import org.springframework.http.ResponseEntity;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.BooksRepository;

import java.util.Optional;

public class GetBookByIdCommand implements Command<ResponseEntity<Book>> {

    private final BooksRepository booksRepository;
    private final Integer bookId;

    public GetBookByIdCommand(BooksRepository booksRepository, Integer bookId) {
        this.booksRepository= booksRepository;
        this.bookId = bookId;
    }

    @Override
    public ResponseEntity<Book> execute() {
        Optional<Book> result = booksRepository.findById(bookId);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}