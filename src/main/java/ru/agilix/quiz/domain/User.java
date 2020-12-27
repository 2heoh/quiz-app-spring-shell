package ru.agilix.quiz.domain;

public class User {
    private final String lastName;
    private final String firstName;
    private int score;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = 0;
    }

    public String getUsername() {
        return firstName + " " + lastName;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score += score;
    }
}
