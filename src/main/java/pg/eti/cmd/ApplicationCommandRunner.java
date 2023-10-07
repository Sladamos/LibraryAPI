package pg.eti.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pg.eti.book.service.api.BookService;
import pg.eti.book.service.api.PublishingHouseService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class ApplicationCommandRunner implements CommandLineRunner {

    private final BookService bookService;

    private final PublishingHouseService publishingHouseService;

    private final Map<String, Runnable> commands;
    
    private final Scanner scanner;

    private boolean isProgramLaunched;


    @Autowired
    public ApplicationCommandRunner(BookService bookService, PublishingHouseService publishingHouseService) {
        isProgramLaunched = false;
        this.bookService = bookService;
        this.publishingHouseService = publishingHouseService;
        scanner = new Scanner(System.in);
        this.commands = createCommands();
    }

    private Map<String, Runnable> createCommands() {
        Map<String, Runnable> commands = new HashMap<>();
        commands.put("print", () -> this.commands.keySet().forEach(System.out::println));
        commands.put("exit", () -> this.isProgramLaunched = false);
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
}
