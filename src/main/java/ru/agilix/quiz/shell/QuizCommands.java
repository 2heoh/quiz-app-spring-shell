package ru.agilix.quiz.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.agilix.quiz.domain.User;
import ru.agilix.quiz.service.IOService;
import ru.agilix.quiz.service.QuestionService;
import ru.agilix.quiz.ui.UIService;

@ShellComponent
public class QuizCommands {
    private User user;
    private boolean userAuthorized = false;
    private boolean hasResults = false;
    private final QuestionService service;
    private final UIService uiService;

    public QuizCommands(QuestionService service, UIService uiService) {
        this.service = service;
        this.uiService = uiService;
    }

    @ShellMethod(value = "Authorization command", key = {"a", "authorize"})
    public String authorize(@ShellOption String firstName, @ShellOption String lastName) {
        this.user = new User(firstName, lastName);
        userAuthorized = true;
        hasResults = false;
        return uiService.displayGreeting(user);
    }

    @ShellMethodAvailability("authCheck")
    @ShellMethod(value = "Start quiz", key = {"s", "start"})
    public String start() {
        user.updateScore(service.runQuiz());
        hasResults = true;
        return uiService.displayNextStep();
    }

    @ShellMethodAvailability("resultsCheck")
    @ShellMethod(value = "Results", key = {"r", "result"})
    public String result() {
        return uiService.displayResultsFor(user);
    }


    @ShellMethod(value = "Reset all ", key = {"reset"})
    public void reset() {
        hasResults=false;
        userAuthorized=false;
    }

    public Availability authCheck() {
        return userAuthorized
                ? Availability.available()
                : Availability.unavailable("you should authorize");
    }

    public Availability resultsCheck() {
        return hasResults
                ? Availability.available()
                : Availability.unavailable("you should take quiz first");
    }

}
