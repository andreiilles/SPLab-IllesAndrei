package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.persistence.BooksRepository;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {

    private final BooksRepository booksRepository;
    private final Integer bookId;
    private final Book updatedBook;

    public UpdateBookCommand(BooksRepository booksRepository, int bookId, Book updatedBook) {
        this.booksRepository = booksRepository;
        this.bookId = bookId;
        this.updatedBook = updatedBook;
    }

    @Override
    public Optional<Book> execute()
    {
        Optional<Book> existingBook = booksRepository.findById(bookId);
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            bookToUpdate.setTitle(updatedBook.getTitle());
            booksRepository.save(bookToUpdate);
            return Optional.of(bookToUpdate);
        }
        return Optional.empty();
    }
}