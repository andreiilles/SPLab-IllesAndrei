package ro.uvt.info.sabloaneproiectarelab2024.services;

public class DeleteBookCommand implements Command<Boolean> {

    private final BooksService booksService;
    private final Long bookId;

    public DeleteBookCommand(BooksService booksService, Long bookId) {
        this.booksService = booksService;
        this.bookId = bookId;
    }

    @Override
    public Boolean execute() {
        return booksService.deleteBook(bookId);
    }
}