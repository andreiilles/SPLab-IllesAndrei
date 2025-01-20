package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.persistence.BooksRepository;

public class DeleteBookCommand implements Command<Boolean> {

    private final BooksRepository booksRepository;
    private final Integer bookId;

    public DeleteBookCommand(BooksRepository booksRepository, Integer bookId) {
        this.booksRepository = booksRepository;
        this.bookId = bookId;
    }

    @Override
    public Boolean execute() {
        if (booksRepository.existsById(bookId)) {
            booksRepository.deleteById(bookId);
            return true;
        }
        return false;
    }
}