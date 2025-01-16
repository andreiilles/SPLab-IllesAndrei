package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {

    private final BooksService booksService;
    private final Long bookId;

    public GetBookByIdCommand(BooksService booksService, Long bookId) {
        this.booksService = booksService;
        this.bookId = bookId;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.getBookById(bookId);
    }
}