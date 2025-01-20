package ro.uvt.info.sabloaneproiectarelab2024.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.sabloaneproiectarelab2024.Book;
import ro.uvt.info.sabloaneproiectarelab2024.services.Observer;

import java.io.IOException;

public class SseObserver implements Observer {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) throws IOException {
        emitter.send(book, MediaType.APPLICATION_JSON);
    }
}
