package ru.agilix.quiz.ui;

import org.springframework.stereotype.Service;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;
import ru.agilix.quiz.service.IOService;

@Service
public class ConsoleUIService implements UIService {
    private final IOService readerWriter;

    public ConsoleUIService(IOService readerWriter) {
        this.readerWriter = readerWriter;
    }

    @Override
    public void displayQuestion(Question question) {

        String text = "\n" + question.getId() + ".) " + question.getKey();

        for (Answer answer : question.getAnswers()) {
            text += "\n\t [" + answer.getId() + "] " + answer.getText();
        }
        readerWriter.displayText(text);
    }

    @Override
    public String displayResultsFor(User user) {
        return "Score for student " + user.getUsername() + " is: " + user.getScore();
    }

    @Override
    public String displayGreeting(User user) {
        return String.format("Welcome: %s, to run quiz type 'start'", user.getUsername());
    }

    @Override
    public String displayNextStep() {
        return "Great! To see result type 'results'";
    }

    @Override
    public String getAnswer() {
        readerWriter.displayText("\nType your answer: ");
        return readerWriter.getText();
    }
}
