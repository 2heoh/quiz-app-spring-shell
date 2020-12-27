package ru.agilix.quiz.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.agilix.quiz.dao.Questionable;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DAOTests {

    @Autowired
    private Questionable dao;

    @Test
    void testQuizShouldHaveOneQuestions() {
        assertThat(dao.getAllQuestions()).size().isEqualTo(1);
    }

}
