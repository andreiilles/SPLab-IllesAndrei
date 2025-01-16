package ro.uvt.info.sabloaneproiectarelab2024.controllers;

import ch.qos.logback.core.net.server.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.sabloaneproiectarelab2024.difexamples.ClientComponent;

@RestController

public class HelloController {
    private final ClientComponent clientComponent;
    public HelloController(ClientComponent clientComponent) {
        this.clientComponent = clientComponent;
    }
    @GetMapping("/")
    public String hello() {
        return "Hello from ClientComponent: " + clientComponent;
    }
}
