package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;

public class CreateBookCommand implements Command<Book> {

    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.createBook(book);
    }
}