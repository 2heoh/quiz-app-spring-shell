package ru.agilix.quiz.service;

import org.springframework.stereotype.Service;
import ru.agilix.quiz.dao.Questionable;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;
import ru.agilix.quiz.ui.UIService;

@Service
public class QuestionFileService implements QuestionService {
    private final Questionable dao;
    private final UIService uiService;

    public QuestionFileService(Questionable dao, UIService uiService) {
        this.dao = dao;
        this.uiService = uiService;
    }

    @Override
    public int runQuiz() {
        int result = 0;
        for (Question question : dao.getAllQuestions()) {
            uiService.displayQuestion(question);
            result += question.scoreAnswer(uiService.getAnswer());
        }
        return result;
    }
}
