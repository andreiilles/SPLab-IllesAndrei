package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {

    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getAllBooks();
    }
}