package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BooksService {
    private final Map<Integer, Book> books = new ConcurrentHashMap<>();
    private int nextId = 1;
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(books.get(id));
    }
    public Book createBook(Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
        return book;
    }
    public Optional<Book> updateBook(int id, Book updatedBook) {
        if (books.containsKey(id)) {
            updatedBook.setId(id);
            books.put(id, updatedBook);
            return Optional.of(updatedBook);
        }
        return Optional.empty();
    }
    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }
}
