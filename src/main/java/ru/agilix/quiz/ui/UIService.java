package ru.agilix.quiz.ui;

import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;

public interface UIService {
    void displayQuestion(Question question);

    String getAnswer();

    String displayResultsFor(User user);

    String displayGreeting(User user);

    String displayNextStep();
}
