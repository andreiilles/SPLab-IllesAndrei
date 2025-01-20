package ro.uvt.info.sabloaneproiectarelab2024.controllers;

import org.springframework.stereotype.Component;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.services.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject {

    private final List<Observer> observers = new ArrayList<>();

    // Attach an observer to the subject
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Detach an observer from the subject
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers about a change
    public void notifyObservers(Book book) throws IOException {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }

    // Optionally, you can add books to the subject
    public void add(Book book) throws IOException {
        notifyObservers(book);
    }
}
