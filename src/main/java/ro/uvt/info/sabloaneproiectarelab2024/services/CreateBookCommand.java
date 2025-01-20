package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.BooksRepository;

public class CreateBookCommand implements Command<Book> {
    private final BooksRepository booksRepository;
    private final Book book;
    public CreateBookCommand(BooksRepository booksRepository, Book book) {
        this.booksRepository = booksRepository;
        this.book = book;
    }
    @Override
    public Book execute() {
        Book createdBook = booksRepository.save(book);
        return createdBook;
    }
}