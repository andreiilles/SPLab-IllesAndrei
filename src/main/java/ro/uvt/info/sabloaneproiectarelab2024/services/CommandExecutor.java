package ro.uvt.info.sabloaneproiectarelab2024.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandExecutor {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void executeSynchronously(Command command) {
        command.execute();
    }

    public void executeAsynchronously(Command command) {
        executor.submit(command::execute);
    }
}
