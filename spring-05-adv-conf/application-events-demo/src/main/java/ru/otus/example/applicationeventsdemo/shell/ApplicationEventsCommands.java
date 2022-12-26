package ru.otus.example.applicationeventsdemo.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.example.applicationeventsdemo.events.EventsPublisher;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private final EventsPublisher eventsPublisher;

    private String userName;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    // реагирует на ключи (если ввести l - то приложение попадет в этот метод)
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) {
        this.userName = userName;
        return String.format("Добро пожаловать: %s", userName);
    }

    // реагирует на ключи
    @ShellMethod(value = "Publish event command", key = {"p", "pub", "publish"})
    // лезет и проверяет метод isPublishEventCommandAvailable(нельзя попасть в метод не
    // залогинившись)
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String publishEvent() {
        eventsPublisher.publish();
        return "Событие опубликовано";
    }

    private Availability isPublishEventCommandAvailable() {
        return userName == null? Availability.unavailable("Сначала залогиньтесь"): Availability.available();
    }
}
