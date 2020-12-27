package ru.agilix.quiz.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void usernameCreatesByConcatenationOfFirstAndLastNames() {
        User user = new User("john", "doe");

        assertThat(user.getUsername()).isEqualTo("john doe");
    }

    @Test
    void scoreIsZeroByDefault() {
        User user = new User(null, null);

        assertEquals(0, user.getScore());
    }

    @Test
    void scoreCanBeUpdated() {
        User user = new User("test", null);

        user.updateScore(1);

        assertEquals(1, user.getScore());
    }
}