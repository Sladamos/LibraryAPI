package pg.eti.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pg.eti.book.comparator.BookComparator;
import pg.eti.book.comparator.PublishingHouseComparator;
import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.service.api.BookService;
import pg.eti.book.service.api.PublishingHouseService;
import pg.eti.shutdown.ApplicationShutdownManager;

import java.util.*;

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
        commands.put("print", () -> this.commands.keySet().stream()
                .map(command -> command.substring(0, 1).toUpperCase() + command.substring(1))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println));

        commands.put("exit", this::disableProgramFunction);

        commands.put("list all publishing houses", () -> publishingHouseService.findAll()
                .stream()
                .sorted(new PublishingHouseComparator())
                .forEach(System.out::println));

        commands.put("list everything", () -> publishingHouseService.findAll()
                .stream()
                .sorted(new PublishingHouseComparator())
                .forEach((house) -> {
                System.out.println(house);
                bookService.findAllByPublishingHouse(house.getId())
                        .ifPresent(el -> el.stream()
                                .sorted(new BookComparator())
                                .forEach(book -> System.out.println("\t" + book)));
            })
        );

        commands.put("list all books", () -> bookService.findAll()
                .stream()
                .sorted(new BookComparator())
                .forEach(System.out::println));

        commands.put("add book", () -> {
            commands.get("list all publishing houses").run();
            System.out.println("Provide publishing house ID");
            Optional<PublishingHouse> publishingHouse = publishingHouseService.find(UUID.fromString(scanner.nextLine()));
            if(publishingHouse.isPresent()) {
                System.out.println("Provide ID, title and author");
                Book book = Book.builder()
                        .id(UUID.fromString(scanner.nextLine()))
                        .title(scanner.nextLine())
                        .author(scanner.nextLine())
                        .publishingHouse(publishingHouse.get())
                        .build();
                bookService.create(book);
                System.out.println("Book created properly");
            } else {
                System.out.println("Incorrect publishing house id");
            }
        });

        commands.put("delete book", () -> {
            System.out.println("Provide ID");
            UUID id = UUID.fromString(scanner.nextLine());
            bookService.delete(id);
            System.out.println("Book removed properly.");
        });
        return commands;
    }

    @Override
    public void run(String... args) throws Exception {
        isProgramLaunched = true;
        commands.get("print").run();
        while (isProgramLaunched) {
            String command = scanner.nextLine().toLowerCase();
            if (commands.containsKey(command)) {
                try {
                    commands.get(command).run();
                } catch (Exception ignored) {
                    System.out.println("Bad command");
                }
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
