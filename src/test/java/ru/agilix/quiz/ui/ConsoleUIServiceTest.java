package ru.agilix.quiz.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;
import ru.agilix.quiz.service.IOService;
import ru.agilix.quiz.ui.ConsoleUIService;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ConsoleUIServiceTest {

    @Mock
    private IOService readerWriter;

    private ConsoleUIService consoleUIService;

    @BeforeEach
    void setUp() {
        consoleUIService = new ConsoleUIService(readerWriter);
    }

    @Test
    void displayQuestion() {
        List<Answer> answers = Collections.singletonList(new Answer(0, "a", true));

        consoleUIService.displayQuestion(new Question(1, "some text", answers));

        verify(readerWriter).displayText("\n1.) some text\n\t [A] a");
    }

    @Test
    void displayResultsFor() {
        String result = consoleUIService.displayResultsFor(new User("test", "test"));

        assertThat(result).isEqualTo("Score for student test test is: 0");
    }

    @Test
    void getAnswer() {
        given(readerWriter.getText()).willReturn("test");

        String answer = consoleUIService.getAnswer();

        assertThat(answer).isEqualTo("test");
    }

    @Test
    void displayGreeting() {
        User user = new User("John", "Doe");
        user.updateScore(1);

        String result = consoleUIService.displayGreeting(user);

        assertThat(result).isEqualTo("Welcome: John Doe, to run quiz type 'start'");
    }

    @Test
    void displayNextStep() {
        String result = consoleUIService.displayNextStep();

        assertThat(result).isEqualTo("Great! To see result type 'results'");
    }
}