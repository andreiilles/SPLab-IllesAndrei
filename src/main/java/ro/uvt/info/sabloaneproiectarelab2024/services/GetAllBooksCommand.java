package ro.uvt.info.sabloaneproiectarelab2024.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.BooksRepository;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksRepository booksRepository;

    public GetAllBooksCommand(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    @Override
    public List<Book> execute() {
        return booksRepository.findAll();
    }
}