package ro.uvt.info.sabloaneproiectarelab2024.services;

import ro.uvt.info.sabloaneproiectarelab2024.Book;

import java.io.IOException;

public interface Observer {
    void update(Book book) throws IOException;
}