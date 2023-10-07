package pg.eti.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pg.eti.book.service.api.BookService;
import pg.eti.book.service.api.PublishingHouseService;
import pg.eti.shutdown.ApplicationShutdownManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class ApplicationCommandRunner implements CommandLineRunner {

    private final ApplicationShutdownManager applicationShutdownManager;

    private final BookService bookService;

    private final PublishingHouseService publishingHouseService;

    private final Map<String, Runnable> commands;
    
    private final Scanner scanner;

    private boolean isProgramLaunched;


    @Autowired
    public ApplicationCommandRunner(ApplicationShutdownManager applicationShutdownManager,
                                    BookService bookService,
                                    PublishingHouseService publishingHouseService) {
        this.applicationShutdownManager = applicationShutdownManager;
        this.bookService = bookService;
        this.publishingHouseService = publishingHouseService;
        this.commands = createCommands();
        scanner = new Scanner(System.in);
        isProgramLaunched = false;
    }

    private Map<String, Runnable> createCommands() {
        Map<String, Runnable> commands = new HashMap<>();
        commands.put("print", () -> this.commands.keySet().forEach(System.out::println));
        commands.put("exit", this::disableProgramFunction);
        commands.put("list_all_publishing_houses", () -> publishingHouseService.findAll().forEach(System.out::println));
        commands.put("list_all_books", () -> bookService.findAll().forEach(System.out::println));
        //commands.put("add_book");
        //commands.put("delete_book");
        return commands;
    }

    @Override
    public void run(String... args) throws Exception {
        isProgramLaunched = true;
        commands.get("print").run();
        while (isProgramLaunched) {
            String command = scanner.next();
            if (commands.containsKey(command)) {
                commands.get(command).run();
            } else {
                System.out.println("Bad command");
            }
        }
    }

    private void disableProgramFunction() {
        isProgramLaunched = false;
        applicationShutdownManager.initiateShutdown(200);
    }
}
