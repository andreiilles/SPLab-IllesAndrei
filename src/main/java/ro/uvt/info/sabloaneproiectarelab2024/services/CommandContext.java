package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.services.BooksService;

public class CommandContext {
    private final BooksService booksService;

    public CommandContext(BooksService booksService) {
        this.booksService = booksService;
    }

    public BooksService getBooksService() {
        return booksService;
    }
}