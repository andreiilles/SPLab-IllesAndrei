package ro.uvt.info.sabloaneproiectarelab2024.services;
package com.example.books.service;

import ro.uvt.info.sabloaneproiectarelab2024.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BooksService {

    // In-memory storage for books
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private long nextId = 1; // For generating unique IDs

    // Get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    // Get a single book by ID
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    // Create a new book
    public Book createBook(Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
        return book;
    }

    // Update a book by ID
    public Optional<Book> updateBook(Long id, Book updatedBook) {
        if (books.containsKey(id)) {
            updatedBook.setId(id);
            books.put(id, updatedBook);
            return Optional.of(updatedBook);
        }
        return Optional.empty();
    }

    // Delete a book by ID
    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }
}
