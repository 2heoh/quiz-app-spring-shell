package ru.agilix.quiz.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.agilix.quiz.service.QuestionService;
import ru.agilix.quiz.ui.UIService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class QuizServiceTest {

    @Autowired
    QuestionService questionService;

    @MockBean
    UIService uiService;

    @Test
    void runQuizShouldReturn1OnCorrectAnswer() {
        given(uiService.getAnswer()).willReturn("a");

        int result = questionService.runQuiz();

        assertThat(result).isEqualTo(1);
    }
}
