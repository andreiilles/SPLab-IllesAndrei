package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {

    private final BooksService booksService;
    private final Long bookId;
    private final Book updatedBook;

    public UpdateBookCommand(BooksService booksService, Long bookId, Book updatedBook) {
        this.booksService = booksService;
        this.bookId = bookId;
        this.updatedBook = updatedBook;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.updateBook(bookId, updatedBook);
    }
}